package com.example.lab09_meneses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ScreenCountries(navController: NavHostController, viewModel: CountryViewModel) {
    val countries by viewModel.countries.collectAsState()
    val searchQuery = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.loadAllCountries()
    }

    Column {
        Row(modifier = Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = { searchQuery.value = it },
                label = { Text("Buscar país") },
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {
                    val query = searchQuery.value.trim()
                    if (query.isNotEmpty()) {
                        navController.navigate("detalle/$query")
                    }
                }
            ) {
                Icon(Icons.Outlined.Search, contentDescription = "Buscar")
            }
        }

        LazyColumn {
            items(countries) { country ->
                Text(text = country.name.common)
            }
        }
    }
}
