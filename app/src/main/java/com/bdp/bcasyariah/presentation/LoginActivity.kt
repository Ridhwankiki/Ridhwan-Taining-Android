package com.bdp.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.databinding.ActivityLoginBinding
import com.bdp.bcasyariah.utils.SharePrefHelper
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityLoginBinding

    private lateinit var sharePref: SharePrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)
        checkToken()
        handleLogin()


        val tvRegister = findViewById<TextView>(R.id.tvRegister)
        tvRegister.setOnClickListener {
            handleRegister()
        }

        binding.cbShowPassword.setOnClickListener{
            val cbShowPassword = binding.cbShowPassword
            if(cbShowPassword.isChecked) {
                binding.passLogin.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.passLogin.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }

    private fun handleLogin() {
        val emailLogin = binding.emailLogin.text

        val passLogin = findViewById<EditText>(R.id.passLogin)
        val passLoginValue = passLogin.text

        binding.btnLogin.setOnClickListener{
            if(binding.emailLogin.text.isEmpty().not() && binding.passLogin.text.isEmpty().not()) {
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
//                handleRegister()
                handleDashboard()
            } else {
                showToast("Email atau Password Anda Salah!")
//                Toast.makeText(this,"Tolong Lengkapi Email dan Password Anda")
            }
//            val intent = Intent(this, ProfileActivity::class.java)
//
//            intent.putExtra(KEY_NAME, emailLogin.toString())
//
//            startActivity(intent)

//            if (emailLoginValue.isEmpty() && passLoginValue.isEmpty()){
//                showToast("Email atau Password Anda Salah!")
//            }else{
//                intentToProfile()
//            }
        }
    }

    private fun checkToken() {
        val getToken = sharePref.getToken()
        if (getToken.isNotEmpty()) {
            handleRegister()
        }
    }

    private fun handleRegister() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun handleDashboard(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun intentToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"
    }
}