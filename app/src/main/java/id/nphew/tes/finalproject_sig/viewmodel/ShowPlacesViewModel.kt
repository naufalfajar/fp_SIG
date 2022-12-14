package id.nphew.tes.finalproject_sig.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.nphew.tes.finalproject_sig.database.Place
import id.nphew.tes.finalproject_sig.database.PlaceDao
import kotlinx.coroutines.launch

class ShowPlacesViewModel(private val placeDao: PlaceDao):ViewModel() {

     val allPlaces= MutableLiveData<List<Place>>()

    /**
     * Get all places from database
     */
    fun getAllPlaces(){
        viewModelScope.launch {
            allPlaces.value=placeDao.getAllPlaces()
        }
    }

}
