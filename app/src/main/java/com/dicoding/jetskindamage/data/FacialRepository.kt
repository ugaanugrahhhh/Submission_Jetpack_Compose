package com.dicoding.jetskindamage.data

import com.dicoding.jetskindamage.model.SkinCondition
import com.dicoding.jetskindamage.model.SkinModel

class FacialRepository {
    fun getFacialDamageSkin(): List<SkinModel> {
        return SkinCondition.skinCondition()
    }

    fun searchFacialDamageSKin(query: String): List<SkinModel> {
        return SkinCondition.skinCondition().filter {
            it.titleSkinProblem.contains(query, ignoreCase = true)
        }
    }
}