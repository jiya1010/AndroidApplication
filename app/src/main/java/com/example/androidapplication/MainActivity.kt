package com.example.androidapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapplication.domain.User
import com.example.androidapplication.presentation.UserViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private var userNameEditText: TextInputEditText? = null
    private var passwordEditText:TextInputEditText? = null
    private var textInputLayout: TextInputLayout? = null
    private var textInputLayout2: TextInputLayout? = null
    private var loginButton: TextView? = null
    private var progressBar: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        loginButton!!.setOnClickListener { loginUser() }
        userViewModel.user.observe(this) {
            Log.wtf("observer","$it")
            Constants.userKey=it.keypass

        }
    }

    private fun loginUser() {
        val username = userNameEditText!!.getText().toString().trim { it <= ' ' }
        val password = passwordEditText!!.getText().toString().trim { it <= ' ' }
        if (TextUtils.isEmpty(username)) {
            textInputLayout!!.error = "Username is required"
            return
        } else {
            textInputLayout!!.error = null
        }
        if (TextUtils.isEmpty(password)) {
            textInputLayout2!!.error = "Password is required"
            return
        } else {
            textInputLayout2!!.error = null
        }
        progressBar!!.visibility = View.VISIBLE

        userViewModel.loginUser(User(username = username, password = password))
    }

    private fun initViews() {
        userNameEditText = findViewById(R.id.userNameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        textInputLayout = findViewById(R.id.textInputLayout)
        textInputLayout2 = findViewById(R.id.textInputLayout2)
        loginButton = findViewById(R.id.loginButton)
        progressBar = findViewById(R.id.progress)

    }
}