package com.bdp.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.base.BaseFragment
import com.bdp.bcasyariah.databinding.FragmentDashboardBinding
import com.bdp.bcasyariah.model.MenuDashboardModel
import com.bdp.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter : DashboardMenuAdapter

    override fun inFlateBinding(
        inFlater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populationDataMenu(),
            context = binding.root.context
        )
    binding.componentMenu.gridMenu.adapter = menuAdapter
    binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener {
        _, _, position, _ ->
    Toast.makeText(
        binding.root.context,
        populationDataMenu()[position].menuName,
        Toast.LENGTH_SHORT
    ).show()
    }
    }


    private fun populationDataMenu(): List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "Transfer"
            ),
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "Pembelian"
            ),
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "Pembayaran"
            ),
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "Cardless"
            ),
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "History Transaksi"
            ),
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "Mutasi Rekening"
            ),
            MenuDashboardModel(
                image = R.drawable.ic_inbox,
                menuName = "Jadwal Sholat"
            )
        )
    }
}

