package com.example.mobile_app_final_assignment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.viewmodel.LoginScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.mobile_app_final_assignment.databinding.FragmentLoginBinding


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        // Setup spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.campus_location,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.campusLocationSpinner.adapter = adapter
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val location = binding.campusLocationSpinner.selectedItem.toString()

            viewModel.login(location, username, password)
        }

        viewModel.loginState.observe(viewLifecycleOwner) { result ->
            result.onSuccess { response ->
                Toast.makeText(requireContext(), "Login success: ${response.keypass}", Toast.LENGTH_SHORT).show()
                // navigate to dashboard
            }
            result.onFailure { error ->
                Toast.makeText(requireContext(), "Login failed: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
