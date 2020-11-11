package com.test.exchange.http

import com.test.exchange.http.models.ExchangeRatesResponse
import retrofit2.http.GET
import io.reactivex.Observable

interface ExchangeApiService {

    @GET("history?start_at=2020-11-01&end_at=2020-11-09&base=USD&symbols=EUR")
    fun getRatesDollar(): Observable<ExchangeRatesResponse>

}