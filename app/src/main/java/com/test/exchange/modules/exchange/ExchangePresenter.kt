package com.test.exchange.modules.exchange

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.test.exchange.utilities.Helpers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ExchangePresenter(model: IExchangeMVP.model) : IExchangeMVP.presenter {
    var model: IExchangeMVP.model = model
    lateinit var context: Context
    lateinit var view: IExchangeMVP.view
    var subscription = CompositeDisposable()
    var helpers = Helpers()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getDataExchange() {

        if (helpers.getConnectivityStatus(context)){
            var subscribe = model.getInfoExchange().subscribeOn(Schedulers.io())
                .subscribe {
                    view.setDataToGraphic(it)
                    Log.i("exchRates", it.toString())
                }

            subscription.add(subscribe)
        }else{
            view.showNotNetworkConnection()
        }
    }

    override fun rxJavaUnsuscribe() {
        subscription.clear()
        if (subscription.isDisposed) {
            subscription.dispose()
        }
    }

    override fun setViewContext(view: IExchangeMVP.view, context: Context) {
        this.view = view
        this.context = context
    }
}