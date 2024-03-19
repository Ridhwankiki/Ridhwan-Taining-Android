package com.bdp.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityRegisterBinding

    private var defaultPasswordVisibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        handleRegister()

        val tvLogin = findViewById<TextView>(R.id.tvLogin)
        tvLogin.setOnClickListener {
            handleLogin()
        }

        binding.ivPassword.setOnClickListener {
            defaultPasswordVisibility = !defaultPasswordVisibility

            if (defaultPasswordVisibility) {
                binding.ivPassword.setImageResource(R.drawable.ic_blur_off)
                binding.etPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                binding.ivPassword.setImageResource(R.drawable.ic_blur_on)
                binding.etPass.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
        }
    }

    private fun handleLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun handleRegister() {
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val etName = findViewById<EditText>(R.id.etName)
        val nameValue =  etName.text

        val etPass = findViewById<EditText>(R.id.etPass)
        val passValue = etPass.text

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val emailValue = etEmail.text

        btnRegister.setOnClickListener{

            if (nameValue.isEmpty() && passValue.isEmpty() && emailValue.isEmpty()){
                showToast("Harap Lengkapi Data!")
            }else{
                showToast("Halo $nameValue, Register Berhasil!")
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}