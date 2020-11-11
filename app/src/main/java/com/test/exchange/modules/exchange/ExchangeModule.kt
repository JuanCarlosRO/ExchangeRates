package com.test.exchange.modules.exchange

import com.test.exchange.http.ExchangeApiService
import dagger.Module
import dagger.Provides

@Module
class ExchangeModule {

    @Provides
    fun provideExchangePresenter(model: IExchangeMVP.model): IExchangeMVP.presenter {
        return ExchangePresenter(model)
    }

    @Provides
    fun provideExchangeModel(repository: IExchangeRepository): IExchangeMVP.model {
        return ExchangeModel(repository)
    }

    @Provides
    fun provideExchangeRepository(apiService: ExchangeApiService): IExchangeRepository {
        return ExchangeRepositoryImp(apiService)
    }

}