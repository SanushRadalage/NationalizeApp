package com.sanush.nationalize.presentation.getCountries

import com.sanush.nationalize.domain.model.Country

data class CountryListState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)
