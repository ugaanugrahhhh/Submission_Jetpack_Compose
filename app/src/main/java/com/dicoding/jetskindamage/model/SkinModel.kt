package com.dicoding.jetskindamage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SkinModel(
    val id: Int,
    val imgSkinProblem: Int,
    val titleSkinProblem: String,
    val dateSkinProblem: String,
    val descSkinProblem: String,
    val language : String,
    val igLink: String,
    val twitterLink: String,
    val fbLink: String,
    val disease: String,
) : Parcelable
