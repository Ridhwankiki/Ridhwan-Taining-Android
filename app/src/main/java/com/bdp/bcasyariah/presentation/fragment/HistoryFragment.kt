package com.bdp.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bdp.bcasyariah.base.BaseFragment
import com.bdp.bcasyariah.databinding.FragmentMessageBinding

class HistoryFragment : BaseFragment<FragmentMessageBinding>() {
    override fun inFlateBinding(inFlater: LayoutInflater, container: ViewGroup?): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {

    }
}