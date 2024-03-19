package com.bdp.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bdp.bcasyariah.adapter.MessageTabAdapter
import com.bdp.bcasyariah.base.BaseFragment
import com.bdp.bcasyariah.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment : BaseFragment<FragmentMessageBinding>() {

    private var adapterMessage : MessageTabAdapter? = null

    override fun inFlateBinding(inFlater: LayoutInflater, container: ViewGroup?): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {
        setupTabView()
    }

    private fun setupTabView() {
        val tabLayout = binding.tabMessage
        val viewPager = binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addListFragment(NotificationFragment())
        adapterMessage?.addListFragment(HistoryFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Notification"
                }
                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }

}