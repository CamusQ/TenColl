package com.example.tencoll

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stu(
    val name: String,
    val age: Int
) : Parcelable

