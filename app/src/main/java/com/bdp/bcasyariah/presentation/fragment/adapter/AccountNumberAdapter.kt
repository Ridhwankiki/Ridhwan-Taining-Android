package com.bdp.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bdp.bcasyariah.databinding.ItemAccountNumberBinding
import com.bdp.bcasyariah.model.AccountNumberModel


class AccountNumberAdapter(
    private val data: List<AccountNumberModel>
) : RecyclerView.Adapter<AccountNumberAdapter.AccountNumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        return AccountNumberViewHolder(
            ItemAccountNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class AccountNumberViewHolder(
        val binding: ItemAccountNumberBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: AccountNumberModel){
            binding.tvSavingType.text = data.savingType.toString()
            binding.tvAccountNumber.text = data.numberRekening.toString()
            binding.tvBalance.text = data.balanceAmount
        }

    }
}