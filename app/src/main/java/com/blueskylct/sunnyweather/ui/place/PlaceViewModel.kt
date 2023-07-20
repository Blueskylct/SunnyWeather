package com.blueskylct.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.blueskylct.sunnyweather.logic.Repository
import com.blueskylct.sunnyweather.logic.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLivedata = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLivedata){
        Repository.searchPlaces(it)
    }

    fun searchPlaces(query : String) {
        searchLivedata.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSharedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}