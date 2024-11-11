package com.example.lab09_meneses

class CountryRepository(private val apiService: CountryApiService) {
    suspend fun fetchAllCountries() = apiService.getAllCountries()
    suspend fun fetchCountryByName(name: String) = apiService.getCountryByName(name)
}
