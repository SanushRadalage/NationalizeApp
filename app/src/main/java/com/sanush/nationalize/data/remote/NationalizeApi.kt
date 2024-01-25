package com.sanush.nationalize.data.remote

import com.sanush.nationalize.data.remote.dto.CountriesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NationalizeApi {
    @GET("?")
    suspend fun getCountries(@Query("name") surname: String): CountriesResponseDto
}