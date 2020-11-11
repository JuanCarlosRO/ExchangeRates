package com.test.exchange.root

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (private val application: Application){

    @Provides
    @Singleton
    fun provideContext(): Application{
        return application
    }
}