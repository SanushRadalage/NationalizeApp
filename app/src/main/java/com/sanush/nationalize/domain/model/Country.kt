package com.sanush.nationalize.domain.model

import com.sanush.nationalize.data.remote.dto.CountryDto

data class Country(
    val countryId: String,
    val probability: Float
)

fun CountryDto.toCountry(): Country {
    return Country(
        countryId, probability.toFloat()
    )
}
