package com.sanush.nationalize.domain.repository

import com.sanush.nationalize.data.remote.dto.CountriesResponseDto

interface CountryRepository {
    suspend fun getCountries(surname: String): CountriesResponseDto
}