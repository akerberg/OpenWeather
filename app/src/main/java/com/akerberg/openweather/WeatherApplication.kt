package com.akerberg.openweather

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import com.akerberg.openweather.data.WeatherRepository
import com.akerberg.openweather.ui.WeatherViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(modules)
        }
    }

    private val modules = module {
        single { WeatherRepository() }
        viewModel { (handle: SavedStateHandle, cityId: Int) ->
            WeatherViewModel(handle, cityId, get())
        }
    }
}