package com.test.exchange.root

import com.test.exchange.http.ExchangeApiModule
import com.test.exchange.modules.exchange.ExchangeModule
import com.test.exchange.modules.exchange.MainActivity
import dagger.Component

@Component(
    modules = arrayOf(
        ApplicationModule::class,
        ExchangeApiModule::class,
        ExchangeModule::class
    )
)
interface ApplicationComponent {
    fun inject(target: MainActivity)
}