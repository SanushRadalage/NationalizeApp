package com.sanush.nationalize.domain.useCase.getCountries

import com.sanush.nationalize.common.Resource
import com.sanush.nationalize.domain.model.Country
import com.sanush.nationalize.domain.model.toCountry
import com.sanush.nationalize.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Get Countries UseCase invoke getCountries in Country Repository
 */
class GetCountriesUseCase @Inject constructor(private val repository: CountryRepository) {
    operator fun invoke(surname: String): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading())
            val countries = repository.getCountries(surname).country.map { it.toCountry() }
            emit(Resource.Success(countries))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}