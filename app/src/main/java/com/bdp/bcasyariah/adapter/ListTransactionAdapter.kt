package com.bdp.bcasyariah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdp.bcasyariah.databinding.ItemListtransactionBinding
import com.bdp.bcasyariah.model.TransactionModel

class ListTransactionAdapter: RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>() {

    private var _data: MutableList<TransactionModel> = mutableListOf()

    private var _onClickTransaction: (TransactionModel) -> Unit = {}

    fun setData(newData: MutableList<TransactionModel>) {
        _data = newData
        notifyDataSetChanged()
    }

    fun setOnClickTransaction(listener: (TransactionModel) -> Unit) {
        _onClickTransaction = listener
    }

    inner class TransactionViewHolder(private val binding:ItemListtransactionBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TransactionModel, _onClickTransaction: (TransactionModel) -> Unit) {
            binding.tvStatusTransaction.text = item.transferStatus
            binding.tvTransferType.text = item.transferType
            binding.tvDate.text = item.date
            binding.tvAmount.text = item.amount.toString()
            binding.tvTransferDestination.text = item.transferDestination

            binding.root.setOnClickListener { _onClickTransaction.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            ItemListtransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position], _onClickTransaction)
    }
}