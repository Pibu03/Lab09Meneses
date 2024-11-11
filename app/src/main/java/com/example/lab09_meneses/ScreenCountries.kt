package com.example.lab09_meneses

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ScreenCountries(viewModel: CountryViewModel) {
    val countries by viewModel.countries.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadAllCountries()
    }

    LazyColumn {
        items(countries) { country ->
            Text(text = country.name.common)
        }
    }
}
