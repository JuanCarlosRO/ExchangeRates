package com.test.exchange.modules.exchange

import android.content.Context
import com.test.exchange.http.models.ExchangeRatesResponse
import io.reactivex.Observable

interface IExchangeMVP {

    interface view {
        fun setDataToGraphic(exchangeRatesResponse: ExchangeRatesResponse)
        fun showNotNetworkConnection()
    }

    interface presenter {
        fun getDataExchange()
        fun rxJavaUnsuscribe()
        fun setViewContext(view: view, context: Context)
    }

    interface model {
        fun getInfoExchange(): Observable<ExchangeRatesResponse>
    }
}