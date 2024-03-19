package com.bdp.bcasyariah.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.databinding.ActivityDetailTransactionBinding
import com.bdp.bcasyariah.model.TransactionModel
import com.bdp.bcasyariah.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY

class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)

        binding.tvDate.text = transaction?.date
        binding.tvTransferType.text = transaction?.transferType
        binding.tvStatusTransaction.text = transaction?.transferStatus
        binding.tvAmount.text = transaction?.amount.toString()
        binding.tvTransferDestination.text = transaction?.transferDestination
    }
}