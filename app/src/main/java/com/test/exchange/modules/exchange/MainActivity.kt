package com.test.exchange.modules.exchange

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.test.exchange.R
import com.test.exchange.http.models.ExchangeRatesResponse
import com.test.exchange.root.DaggerApplicationComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IExchangeMVP.view {

    @Inject
    lateinit var presenter: IExchangeMVP.presenter

    @BindView(R.id.chart)
    lateinit var chart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        ButterKnife.bind(this)

        injectDependency()

    }

    override fun onResume() {
        super.onResume()
        presenter.setViewContext(this, this)
        presenter.getDataExchange()
    }

    override fun onStop() {
        super.onStop()
        presenter.rxJavaUnsuscribe()
    }

    override fun setDataToGraphic(exchData: ExchangeRatesResponse) {

        Thread(Runnable {
            this.runOnUiThread {

                val labelsName = ArrayList<String>()
                labelsName.add("11-02-20")
                labelsName.add("11-02-20")
                labelsName.add("11-03-20")
                labelsName.add("11-04-20")
                labelsName.add("11-05-20")
                labelsName.add("11-06-20")

                val values: MutableList<BarEntry> = ArrayList()
                values.add(BarEntry(1f, exchData.rates.`2020-11-02`.EUR.toFloat()))
                values.add(BarEntry(2f, exchData.rates.`2020-11-03`.EUR.toFloat()))
                values.add(BarEntry(3f, exchData.rates.`2020-11-04`.EUR.toFloat()))
                values.add(BarEntry(4f, exchData.rates.`2020-11-05`.EUR.toFloat()))
                values.add(BarEntry(5f, exchData.rates.`2020-11-06`.EUR.toFloat()))

                var barDataSet = BarDataSet(values, "Historical dollar-euro exchange rates")
                barDataSet.valueTextSize = 16f

                barDataSet.setColors(
                    ColorTemplate.MATERIAL_COLORS[0],
                    ColorTemplate.MATERIAL_COLORS[1],
                    ColorTemplate.MATERIAL_COLORS[2],
                    ColorTemplate.MATERIAL_COLORS[3],
                    ColorTemplate.COLORFUL_COLORS[0]
                )

                var barData = BarData(barDataSet)

                var xaxis = chart.xAxis
                xaxis.valueFormatter = IndexAxisValueFormatter(labelsName)
                xaxis.position = XAxis.XAxisPosition.BOTTOM

                chart.description = null
                chart.setFitBars(true)
                chart.data = barData
                chart.animateY(2000)
            }
        }).start()

    }

    override fun showNotNetworkConnection() {
        Toast.makeText(applicationContext, getString(R.string.not_network_connection_txt), Toast.LENGTH_SHORT)
            .show()
    }

    private fun injectDependency() {
        val component = DaggerApplicationComponent.builder()
            .exchangeModule(ExchangeModule())
            .build()
        component.inject(this)
    }
}