package com.bdp.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bdp.bcasyariah.base.BaseFragment
import com.bdp.bcasyariah.databinding.FragmentMessageBinding
import com.bdp.bcasyariah.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun inFlateBinding(
        inFlater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {

    }

}