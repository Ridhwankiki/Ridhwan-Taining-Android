package com.bdp.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.base.BaseFragment
import com.bdp.bcasyariah.databinding.FragmentDashboardBinding
import com.bdp.bcasyariah.model.AccountNumberModel
import com.bdp.bcasyariah.model.MenuDashboardModel
import com.bdp.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.bdp.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
import com.bdp.bcasyariah.utils.HorizontalItemDecoration

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter : DashboardMenuAdapter

    private lateinit var accountAdapter : AccountNumberAdapter

    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelOffset(R.dimen.spacing16),
            true
        )
    }

    override fun inFlateBinding(
        inFlater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {
        setupViewMenu()
        setupViewAccountNumber()
    }

    private fun setupViewMenu() {
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

    private fun setupViewAccountNumber() {
        accountAdapter = AccountNumberAdapter(
            data = populationDataAccountNumber(),
        )
        binding.componentAccountNumber.rvAccountNumber.adapter = accountAdapter
        binding.componentAccountNumber.rvAccountNumber.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentAccountNumber.rvAccountNumber.apply {
            if (itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
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

    private fun populationDataAccountNumber(): List<AccountNumberModel> {
        return listOf(
            AccountNumberModel(
                savingType = 1,
                numberRekening = 1234567890,
                balanceAmount = "Rp.1.000.000"
            ),
            AccountNumberModel(
                savingType = 0,
                numberRekening = 0,
                balanceAmount = ""
            ),
            AccountNumberModel(
                savingType = 0,
                numberRekening = 0,
                balanceAmount = ""
            ),
        )
    }

}

