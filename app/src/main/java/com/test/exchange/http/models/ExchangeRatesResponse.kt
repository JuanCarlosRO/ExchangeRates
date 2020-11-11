package com.test.exchange.http.models

data class ExchangeRatesResponse(
    val base: String,
    val end_at: String,
    val rates: Rates,
    val start_at: String
)

data class Rates(
    val `2020-11-02`: X20201102,
    val `2020-11-03`: X20201103,
    val `2020-11-04`: X20201104,
    val `2020-11-05`: X20201105,
    val `2020-11-06`: X20201106,
    val `2020-11-09`: X20201109
)

data class X20201102(
    val EUR: Double
)

data class X20201103(
    val EUR: Double
)

data class X20201104(
    val EUR: Double
)

data class X20201105(
    val EUR: Double
)

data class X20201106(
    val EUR: Double
)

data class X20201109(
    val EUR: Double
)