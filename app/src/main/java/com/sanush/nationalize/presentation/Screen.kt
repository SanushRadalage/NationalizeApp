package com.sanush.nationalize.presentation

/**
 * Routes of the screens
 */
sealed class Screen(val route: String) {
    data object CountryListScreen: Screen("country_list_screen")
}