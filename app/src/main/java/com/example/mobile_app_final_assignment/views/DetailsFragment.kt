package com.example.mobile_app_final_assignment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.viewmodels.DetailsScreenViewModel
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {


    private val viewModel: DetailsScreenViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameText = view.findViewById<TextView>(R.id.nameText)
        val architectName = view.findViewById<TextView>(R.id.architectName)
        val location = view.findViewById<TextView>(R.id.locationText)
        val yearCompleted = view.findViewById<TextView>(R.id.yearCompletedText)
        val style = view.findViewById<TextView>(R.id.styleText)
        val height = view.findViewById<TextView>(R.id.heightText)
        val descriptionText = view.findViewById<TextView>(R.id.descriptionText)
        val backButton = view.findViewById<ImageButton>(R.id.backButton)

        viewModel.item.observe(viewLifecycleOwner) { item ->
            nameText.text = item.name
            architectName.text = item.architect
            location.text = item.location
            yearCompleted.text = item.yearCompleted
            style.text = item.style
            height.text = item.height.toString()
            descriptionText.text = item.description
        }


        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
