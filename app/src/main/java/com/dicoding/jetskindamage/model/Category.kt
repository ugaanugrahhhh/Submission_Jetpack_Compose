package com.dicoding.jetskindamage.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dicoding.jetcoffee.R


data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int
)

val dummyCategory = listOf(
    R.drawable.icon_category_eczema to R.string.category_eczema,
    R.drawable.icon_category_acne to R.string.category_acne,
    R.drawable.icon_category_actinic_keratosis to R.string.category_actinic_keratosis,
    R.drawable.icon_category_blister to R.string.category_blister,
    R.drawable.icon_category_carbuncle to R.string.category_carbuncle,
    R.drawable.icon_category_cellulitis to R.string.category_cellulitis,
    R.drawable.icon_category_cold_sores to R.string. category_cold_sores,
    R.drawable.icon_category_contact_dermatitis to R.string.category_contact_dermatitis,
    R.drawable.icon_category_hives to R.string.category_hives,
    R.drawable.icon_category_latex_allergy to R.string.category_latex_allergy,
    R.drawable.icon_category_lupus to R.string.category_lupus,
    R.drawable.icon_category_measles to R.string.category_measles,
    R.drawable.icon_category_rosacea to R.string.category_psoriasis,
    R.drawable.icon_category_psoriasis to R.string.category_rosacea,
).map { Category(it.first, it.second) }