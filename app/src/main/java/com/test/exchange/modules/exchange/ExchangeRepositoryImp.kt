package com.test.exchange.modules.exchange

import com.test.exchange.http.ExchangeApiService
import com.test.exchange.http.models.ExchangeRatesResponse
import io.reactivex.Observable

class ExchangeRepositoryImp(apiService: ExchangeApiService) : IExchangeRepository {
    val apiService: ExchangeApiService = apiService

    override fun getDataExchangeDollar(): Observable<ExchangeRatesResponse> {
        return apiService.getRatesDollar()
    }
}