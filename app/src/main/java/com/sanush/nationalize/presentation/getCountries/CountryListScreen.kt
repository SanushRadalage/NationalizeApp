package com.sanush.nationalize.presentation.getCountries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sanush.nationalize.R
import com.sanush.nationalize.domain.model.Country
import com.sanush.nationalize.presentation.getCountries.components.CountryListItem
import com.sanush.nationalize.presentation.getCountries.components.EmptyItem

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CountryListScreen(viewModel: CountryListViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    var surname by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(value = surname, onValueChange = {
                surname = it
            },
                singleLine = true,
                label = {
                    Text(text = stringResource(id = R.string.enterSurname))
                })
            Button(onClick = {
                surname.let {
                    viewModel.getCountries(surname)
                    keyboardController?.hide()

                }
            }) {
                Text(text = stringResource(id = R.string.search))
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            if (surname.isEmpty()) {
                EmptyItem(modifier = Modifier.align(Alignment.Center))
            } else {
                CountryList(
                    countries = state.countries, modifier = Modifier
                        .fillMaxSize()
                )
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading)
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
            }
        }
    }
}

@Composable
fun CountryList(
    countries: List<Country>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(countries) { country ->
            CountryListItem(country)
            Divider()
        }
    }
}