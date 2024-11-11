package com.example.lab09_meneses

data class CountryModel(
    val name: Name,
    val population: Long,
    val capital: List<String>?,
    val region: String,
    val languages: Map<String, String>?
)

data class Name(
    val common: String
)
