package com.sanush.nationalize.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("country_id")
    val countryId: String,
    val probability: Double
)