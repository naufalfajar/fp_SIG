package id.nphew.tes.finalproject_sig.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.nphew.tes.finalproject_sig.database.Place
import id.nphew.tes.finalproject_sig.database.PlaceDao
import kotlinx.coroutines.launch

class AddPlaceViewModel(private val placeDao: PlaceDao):ViewModel() {

     val message= MutableLiveData<String>()

    /**
     * Inserts the new Place into database.
     */
    fun addNewPlace(name: String, code: String, east: String, north: String, elevation: String) {
        val newPlace = Place(name=name,code=code,east=east.toDouble(), north = north.toDouble(),elevation=elevation.toDouble())
        viewModelScope.launch {
            placeDao.insert(newPlace)
            message.value="New Place saved successfully!"
        }
    }
}