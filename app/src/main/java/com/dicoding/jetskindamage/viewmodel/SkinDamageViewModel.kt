package com.dicoding.jetskindamage.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.jetskindamage.data.FacialRepository
import com.dicoding.jetskindamage.model.SkinModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SkinDamageViewModel(private val repository: FacialRepository): ViewModel() {
    private val _skinDamage = MutableStateFlow(
        repository.getFacialDamageSkin()
    )
    val skinDamage: StateFlow<List<SkinModel>> get() = _skinDamage

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _skinDamage.value = repository.searchFacialDamageSKin(_query.value)
    }
}

class ViewModelFactory(private val repository: FacialRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SkinDamageViewModel::class.java)) {
            return SkinDamageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
