package com.example.mobile_app_final_assignment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.viewmodels.DetailsScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val viewModel: DetailsScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameText = view.findViewById<TextView>(R.id.nameText)
        val architectName = view.findViewById<TextView>(R.id.architectName)
        val descriptionText = view.findViewById<TextView>(R.id.descriptionText)

        viewModel.item.observe(viewLifecycleOwner) { item ->
            nameText.text = item.name
            architectName.text = item.architect
            descriptionText.text = item.description
        }
    }
}
