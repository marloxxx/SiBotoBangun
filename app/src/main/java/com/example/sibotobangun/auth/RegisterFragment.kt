package com.example.sibotobangun.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R
import com.example.sibotobangun.models.Users
import com.example.sibotobangun.models.User
import com.example.sibotobangun.utils.FragmentNavigation

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var nik: EditText
    private lateinit var fullname: EditText
    private lateinit var phone: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        nik = view.findViewById(R.id.editTextNik)
        fullname = view.findViewById(R.id.editTextFullName)
        phone = view.findViewById(R.id.editTextPhone)
        email = view.findViewById(R.id.editTextEmail)
        password = view.findViewById(R.id.editTextPassword)

        view.findViewById<View>(R.id.registerButton).setOnClickListener {
            val nik = nik.text.toString()
            val fullname = fullname.text.toString()
            val phone = phone.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            // show toast message
            if (nik.isEmpty()) {
                Toast.makeText(context, "Please enter NIK", Toast.LENGTH_SHORT)
                    .show()
            } else if (nik.length != 16) {
                Toast.makeText(context, "NIK must be 16 digits", Toast.LENGTH_SHORT)
                    .show()
            } else if (fullname.isEmpty()) {
                Toast.makeText(context, "Please enter fullname", Toast.LENGTH_SHORT)
                    .show()
            } else if (email.isEmpty()) {
                Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT)
                    .show()
            } else if (phone.isEmpty()) {
                Toast.makeText(context, "Please enter phone number", Toast.LENGTH_SHORT)
                    .show()
            } else if (!Regex("[0-9]+").matches(phone)) {
                Toast.makeText(context, "Please enter valid phone number", Toast.LENGTH_SHORT)
                    .show()
            } else if (phone.length < 10 || phone.length > 13) {
                Toast.makeText(context, "Phone number must be 10-13 digits", Toast.LENGTH_SHORT)
                    .show()
            } else if (email.isEmpty()) {
                Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT)
                    .show()
            } else if (!Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matches(email)) {
                Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT)
                    .show()
            } else if (password.isEmpty()) {
                Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val user = User(nik, fullname, phone, email, password)
                // save user data to model
                Users().addUser(user)
                Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT)
                    .show()
                val navLogin = activity as FragmentNavigation
                navLogin.navigateTo(LoginFragment(), false)
            }
        }
        view.findViewById<View>(R.id.loginLink).setOnClickListener {
            val navLogin = activity as FragmentNavigation
            navLogin.navigateTo(LoginFragment(), true)
        }

        return view
    }
}
