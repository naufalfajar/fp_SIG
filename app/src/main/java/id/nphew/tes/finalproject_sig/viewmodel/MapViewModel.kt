package id.nphew.tes.finalproject_sig.viewmodel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.nphew.tes.finalproject_sig.database.PlaceDao

class MapViewModel(private val placeDao: PlaceDao) : ViewModel() {


    private val currentLocation = MutableLiveData<Location>()

    fun saveCurrentLocation(location: Location) {
        currentLocation.value = location
    }

    fun getCurrentLocation(): Location? {
        return currentLocation.value;
    }

}

class PlaceViewModelFactory(private val placeDao:PlaceDao):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MapViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MapViewModel(placeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}