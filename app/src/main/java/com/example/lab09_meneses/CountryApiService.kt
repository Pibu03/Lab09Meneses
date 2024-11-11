package com.example.lab09_meneses

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApiService {
    @GET("v3.1/all")
    suspend fun getAllCountries(): List<CountryModel>

    @GET("v3.1/name/{name}")
    suspend fun getCountryByName(@Path("name") name: String): List<CountryModel>
}
