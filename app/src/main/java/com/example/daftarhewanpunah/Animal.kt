package com.example.daftarhewanpunah

import android.content.ClipDescription
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal (
    var name: String = "",
    var description: String ="",
    var photo: String = ""):Parcelable