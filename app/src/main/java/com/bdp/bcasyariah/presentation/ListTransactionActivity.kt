package com.bdp.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bdp.bcasyariah.adapter.ListTransactionAdapter
import com.bdp.bcasyariah.databinding.ActivityListtransactionBinding
import com.bdp.bcasyariah.model.TransactionModel

class ListTransactionActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityListtransactionBinding

    private var listTransactionAdapter = ListTransactionAdapter()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListtransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())
        listTransactionAdapter.setOnClickTransaction { transaction ->
            navigateToDetailTransaction(transaction)
        }

    }

    private fun navigateToDetailTransaction(data: TransactionModel) {
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY, data)
        startActivity(intent)
    }

    private fun createDummyListTransaction():MutableList<TransactionModel> {
        return mutableListOf(
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Transfer Antar Bank",
                transferDestination = "BCA",
                date = "01/01/01",
                transferStatus = "Failed",
                amount = 100000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/07",
                transferStatus = "Sukses",
                amount = 200000.0
            ),
        )
    }

    companion object {
        const val TRANSACTION_KEY = "transaction_key"
    }
}