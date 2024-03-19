package com.bdp.bcasyariah.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TransactionModel(
    val transferType: String,
    val transferDestination: String,
    val date: String,
    val transferStatus: String,
    val amount: Double
) : Parcelable