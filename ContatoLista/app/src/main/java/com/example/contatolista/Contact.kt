package com.example.contatolista

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var nome:String,
    var telefone:String,
    var foto:String
    ) : Parcelable