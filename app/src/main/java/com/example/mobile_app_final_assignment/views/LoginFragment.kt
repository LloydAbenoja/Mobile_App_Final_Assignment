package com.example.mobile_app_final_assignment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.viewmodel.LoginScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etUsername = view.findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = view.findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = view.findViewById<MaterialButton>(R.id.btnLogin)
        val campusSpinner = view.findViewById<Spinner>(R.id.campusLocationSpinner)

        // optional: populate campus spinner
        val campuses = listOf("footscray", "sydney", "br")
        campusSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            campuses
        )

        btnLogin.setOnClickListener {
            val username = etUsername.text?.toString()?.trim().orEmpty()
            val password = etPassword.text?.toString()?.trim().orEmpty()
            val location = campusSpinner.selectedItem.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.login(location, username, password)
        }

        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoginScreenViewModel.UiState.Loading -> {
                    // show a progress indicator
                }
                is LoginScreenViewModel.UiState.Success -> {
                    val keypass = state.keypass
                    val action = LoginFragmentDirections
                        .actionLoginFragmentToDashboardFragment(keypass)
                    findNavController().navigate(action)
                }
                is LoginScreenViewModel.UiState.Error -> {
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

