package com.bdp.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdp.bcasyariah.databinding.ItemAccountNumberBinding
import com.bdp.bcasyariah.databinding.ItemPromoBinding
import com.bdp.bcasyariah.model.AccountNumberModel
import com.bdp.bcasyariah.model.PromoModel

class PromoAdapter(
    private val data: List<PromoModel>
) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoAdapter.PromoViewHolder {
        return PromoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PromoViewHolder(
        val binding: ItemPromoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PromoModel){
            binding.ivPromo.setImageResource(data.image)
        }

    }


}