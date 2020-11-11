package com.test.exchange.modules.exchange

import com.test.exchange.http.models.ExchangeRatesResponse
import io.reactivex.Observable

class ExchangeModel(repository: IExchangeRepository) : IExchangeMVP.model {
    val repository: IExchangeRepository = repository

    override fun getInfoExchange(): Observable<ExchangeRatesResponse> {
        return repository.getDataExchangeDollar()
    }
}