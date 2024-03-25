package com.bdp.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.base.BaseFragment
import com.bdp.bcasyariah.databinding.FragmentDashboardBinding
import com.bdp.bcasyariah.model.AccountNumberModel
import com.bdp.bcasyariah.model.MenuDashboard
import com.bdp.bcasyariah.model.MenuDashboardModel
import com.bdp.bcasyariah.model.PromoModel
import com.bdp.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.bdp.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
import com.bdp.bcasyariah.presentation.fragment.adapter.PromoAdapter
import com.bdp.bcasyariah.presentation.viewmodel.DashboardViewModel
import com.bdp.bcasyariah.utils.HorizontalItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var menuAdapter : DashboardMenuAdapter

    private lateinit var accountAdapter : AccountNumberAdapter

    private lateinit var promoAdapter: PromoAdapter

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
        setupViewPromo()

        viewModel.getHomeMenu()
        viewModel.getAccountNumber()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it.data)
        }
        viewModel.accountNumber.observe(viewLifecycleOwner){
            setupViewAccountNumber(it)
        }
    }

    private fun setupViewMenu(data: List<MenuDashboard>?) {

//        if(data.isNullOrEmpty().not()) {
//
//        } else {
//
//        }

        menuAdapter = DashboardMenuAdapter(
            menuData = data ?: listOf(),
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener {
                _, _, position, _ ->
            Toast.makeText(
                binding.root.context,
                data?.get(position)?.nameMenu,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupViewAccountNumber(data : List<AccountNumberModel>) {
        accountAdapter = AccountNumberAdapter(
            data = data,
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

    private fun setupViewPromo() {
        promoAdapter = PromoAdapter(
            data = populationPromo(),
        )
        binding.componentPromo.rvPromo.adapter = promoAdapter
        binding.componentPromo.rvPromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentPromo.rvPromo.apply {
            if (itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun populationPromo(): List<PromoModel> {
        return listOf(
            PromoModel(
                image = R.drawable.promo1,
            ),
            PromoModel(
                image = R.drawable.promo2,
            ),
            PromoModel(
                image = R.drawable.promo3,
            ),
        )
    }
}

