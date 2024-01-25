package com.sanush.nationalize.data.repository

import com.sanush.nationalize.data.remote.NationalizeApi
import com.sanush.nationalize.data.remote.dto.CountriesResponseDto
import com.sanush.nationalize.domain.repository.CountryRepository
import javax.inject.Inject

/**
 * Country Repository implementation
 */
class CountryRepositoryImpl @Inject constructor(private val api: NationalizeApi) :
    CountryRepository {
    override suspend fun getCountries(surname: String): CountriesResponseDto {
        return api.getCountries(surname)
    }

}