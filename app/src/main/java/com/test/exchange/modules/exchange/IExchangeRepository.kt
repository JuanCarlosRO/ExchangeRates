package com.test.exchange.modules.exchange

import com.test.exchange.http.models.ExchangeRatesResponse
import io.reactivex.Observable

interface IExchangeRepository {
    fun getDataExchangeDollar() : Observable<ExchangeRatesResponse>
}