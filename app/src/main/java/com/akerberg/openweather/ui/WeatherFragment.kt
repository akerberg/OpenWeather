package com.akerberg.openweather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.akerberg.openweather.R
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.parameter.parametersOf
import kotlin.math.roundToInt

class WeatherFragment : Fragment() {
    private val args: WeatherFragmentArgs by navArgs()
    private val viewModel: WeatherViewModel by stateViewModel() { parametersOf(args.cityId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_weather, container, false)
        val description: TextView = root.findViewById(R.id.description)
        val feelsLike: TextView = root.findViewById(R.id.feels_like)
        val temperature: TextView = root.findViewById(R.id.temperature)
        viewModel.weatherData.observe(viewLifecycleOwner, Observer {
            //TODO Implement better error handling
            it?.let { weatherData ->
                weatherData.weather.firstOrNull()?.let { weather ->
                    description.text = weather.description
                }
                weatherData.main?.let { main ->
                    feelsLike.text = getString(R.string.feels_like, main.feels_like.roundToInt())
                    temperature.text = getString(R.string.temperature, main.temp.roundToInt())
                }
            }
        })
        return root
    }
}