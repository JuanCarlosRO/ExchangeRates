package com.test.exchange.root

import android.app.Application
import com.test.exchange.http.ExchangeApiModule
import com.test.exchange.modules.exchange.ExchangeModule

class App : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .exchangeApiModule(ExchangeApiModule())
            .exchangeModule(ExchangeModule())
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component;
    }
}