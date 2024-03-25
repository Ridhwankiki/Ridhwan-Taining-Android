package com.bdp.bcasyariah.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Inbox
import androidx.fragment.app.Fragment
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.databinding.ActivityHomeBinding
import com.bdp.bcasyariah.presentation.fragment.AdminFragment
import com.bdp.bcasyariah.presentation.fragment.DashboardFragment
import com.bdp.bcasyariah.presentation.fragment.InboxFragment
import com.bdp.bcasyariah.presentation.fragment.MessageFragment
import com.bdp.bcasyariah.utils.ConfirmationDialogUtil
import com.bdp.bcasyariah.utils.SharePrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationInbox -> {
                    replaceFragment(InboxFragment())
                    return@OnNavigationItemSelectedListener  true
                }

                R.id.navigationAdmin -> {
                    replaceFragment(AdminFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener false
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)
        confirmationDialogUtil = ConfirmationDialogUtil(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun showConfirmation(){
        val title = "Apakah anda ingin keluar ?"
        val icon =  R.drawable.ic_admin

        confirmationDialogUtil.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            },
            onCancel = {

            }
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}