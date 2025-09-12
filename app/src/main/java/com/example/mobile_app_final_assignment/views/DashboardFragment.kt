package com.example.mobile_app_final_assignment.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.recyclerview.MyRecyclerViewAdapter
import com.example.mobile_app_final_assignment.viewmodels.DashboardScreenViewModel
import com.example.mobile_app_final_assignment.viewmodels.DashboardUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardScreenViewModel by viewModels()
    private lateinit var adapter: MyRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MyRecyclerViewAdapter { item ->
            // Navigate to DetailsFragment with SafeArgs
            val action = DashboardFragmentDirections
                .actionDashboardFragmentToDetailsFragment(item)
            findNavController().navigate(action)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Load the dashboard (use a key or token from login)
        val keypass = arguments?.getString("keypass") ?: "defaultKey"
        viewModel.loadDashboard(keypass)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dashboardState.collectLatest { state ->
                when (state) {
                    is DashboardUiState.Loading -> {
                        // Optionally show a spinner
                    }
                    is DashboardUiState.Success -> {
                        adapter.setData(state.items)
                    }
                    is DashboardUiState.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
