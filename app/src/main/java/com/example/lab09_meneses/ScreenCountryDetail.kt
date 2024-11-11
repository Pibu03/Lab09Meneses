package com.example.lab09_meneses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenCountryDetail(viewModel: CountryViewModel, countryName: String) {
    val country by viewModel.selectedCountry.collectAsState()

    LaunchedEffect(countryName) {
        viewModel.loadCountryByName(countryName)
    }

    country?.let {
        Column(
            Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = it.name.common,
                onValueChange = {},
                label = { Text("Nombre") },
                readOnly = true
            )
            OutlinedTextField(
                value = it.population.toString(),
                onValueChange = {},
                label = { Text("Población") },
                readOnly = true
            )
            OutlinedTextField(
                value = it.capital?.joinToString() ?: "N/A",
                onValueChange = {},
                label = { Text("Capital") },
                readOnly = true
            )
            OutlinedTextField(
                value = it.region,
                onValueChange = {},
                label = { Text("Región") },
                readOnly = true
            )
        }
    }
}
