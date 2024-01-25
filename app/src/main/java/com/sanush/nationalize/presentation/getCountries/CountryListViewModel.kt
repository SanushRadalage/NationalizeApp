package com.sanush.nationalize.presentation.getCountries

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanush.nationalize.common.Resource
import com.sanush.nationalize.domain.useCase.getCountries.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CountryListState())
    val state: State<CountryListState> = _state


    fun getCountries(
        term: String
    ) {
        getCountriesUseCase(term).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CountryListState(countries = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CountryListState(
                        error = result.message ?: "An unexpected error occurred."
                    )
                }

                is Resource.Loading -> {
                    _state.value = CountryListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}