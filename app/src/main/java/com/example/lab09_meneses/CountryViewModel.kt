package com.example.lab09_meneses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CountryViewModel(private val repository: CountryRepository) : ViewModel() {
    private val _countries = MutableStateFlow<List<CountryModel>>(emptyList())
    val countries: StateFlow<List<CountryModel>> = _countries

    private val _selectedCountry = MutableStateFlow<CountryModel?>(null)
    val selectedCountry: StateFlow<CountryModel?> = _selectedCountry

    fun loadAllCountries() {
        viewModelScope.launch {
            _countries.value = repository.fetchAllCountries()
        }
    }

    fun loadCountryByName(name: String) {
        viewModelScope.launch {
            _selectedCountry.value = repository.fetchCountryByName(name).firstOrNull()
        }
    }
}
