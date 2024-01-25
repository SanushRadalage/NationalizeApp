package com.sanush.nationalize.data.remote.dto

data class CountriesResponseDto(
    val count: Int,
    val country: List<CountryDto>,
    val name: String
)