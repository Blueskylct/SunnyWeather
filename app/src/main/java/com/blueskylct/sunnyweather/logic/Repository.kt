package com.blueskylct.sunnyweather.logic

import androidx.lifecycle.liveData
import com.blueskylct.sunnyweather.logic.model.Place
import com.blueskylct.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query : String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if(placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(java.lang.RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e:java.lang.Exception){
            Result.failure<Place>(e)
        }
        emit(result)
    }
}