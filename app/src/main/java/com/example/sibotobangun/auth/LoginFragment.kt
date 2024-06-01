package com.example.sibotobangun.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sibotobangun.R
import com.example.sibotobangun.app.HomeActivity
import com.example.sibotobangun.models.Users
import com.example.sibotobangun.utils.FragmentNavigation

class LoginFragment : Fragment() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        email = view.findViewById(R.id.editTextEmail)
        password = view.findViewById(R.id.editTextPassword)

        // get user data from model
        val userList = Users().getUserList()

        view.findViewById<View>(R.id.loginButton).setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()
            // show toast message
            if (email.isEmpty()) {
                Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT)
                    .show()
            } else if (!Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matches(email)) {
                Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT)
                    .show()
            } else if (password.isEmpty()) {
                Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var isLogin = false
                for (user in userList) {
                    if (user.email == email && user.password == password) {
                        isLogin = true
                        break
                    }
                }
                if (isLogin) {
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(context, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        view.findViewById<View>(R.id.registerLink).setOnClickListener {
            val navRegister = activity as FragmentNavigation
            navRegister.navigateTo(RegisterFragment(), true)
        }

        return view
    }
}
