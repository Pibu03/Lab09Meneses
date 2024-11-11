package com.example.lab09_meneses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ScreenCountrySearch(navController: NavHostController, viewModel: CountryViewModel) {
    val searchQuery = remember { mutableStateOf("") }
    val country by viewModel.selectedCountry.collectAsState()

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = searchQuery.value,
            onValueChange = { searchQuery.value = it },
            label = { Text("Nombre del país") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                val query = searchQuery.value.trim()
                if (query.isNotEmpty()) {
                    viewModel.loadCountryByName(query)
                }
            }
        ) {
            Text("Buscar")
        }

        country?.let {
            Text(text = "Nombre: ${it.name.common}", Modifier.padding(top = 16.dp))
            Text(text = "Población: ${it.population}")
            Text(text = "Capital: ${it.capital?.joinToString() ?: "N/A"}")
            Text(text = "Región: ${it.region}")
            Text(text = "Idiomas: ${it.languages?.values?.joinToString() ?: "N/A"}")
        }
    }
}
