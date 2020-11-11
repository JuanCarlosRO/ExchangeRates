package com.test.exchange.http

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ExchangeApiModule {

    val BASE_URL = "https://api.exchangeratesapi.io/"

    @Provides
    fun provideRetrofit(): Retrofit {
        val inter = HttpLoggingInterceptor()
        inter.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(inter)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideApiService(): ExchangeApiService {
        return provideRetrofit().create(ExchangeApiService::class.java)
    }

}