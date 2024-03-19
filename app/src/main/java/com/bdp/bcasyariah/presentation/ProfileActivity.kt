package com.bdp.bcasyariah.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bdp.bcasyariah.presentation.LoginActivity.Companion.KEY_NAME
import com.bdp.bcasyariah.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity()  {

    private  lateinit var binding:ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = intent.getStringExtra(KEY_NAME)

        binding.tvEmail.text = "Email : $getName"

        binding.vComponentTopbar.tvTitle.text = "Profile Feature"
        binding.vComponentTopbar.ivBack.setOnClickListener{
            onBackPressed()
        }
    }
}


