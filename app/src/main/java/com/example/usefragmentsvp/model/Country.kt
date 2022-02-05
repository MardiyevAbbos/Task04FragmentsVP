package com.example.usefragmentsvp.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Country(val name: String, val capital: String, val info: String, val flag: Int) : Serializable
