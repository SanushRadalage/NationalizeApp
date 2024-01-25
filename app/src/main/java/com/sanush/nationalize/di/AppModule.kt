package com.sanush.nationalize.di

import com.sanush.nationalize.common.Constants.BASE_URL
import com.sanush.nationalize.data.remote.NationalizeApi
import com.sanush.nationalize.data.repository.CountryRepositoryImpl
import com.sanush.nationalize.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * AppModule object provide http, retrofit and repository instances
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideNationalizeApi(): NationalizeApi {
        return Retrofit.Builder()
            .client(provideHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NationalizeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(api: NationalizeApi): CountryRepository {
        return CountryRepositoryImpl(api)
    }
}