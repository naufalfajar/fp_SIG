package id.nphew.tes.finalproject_sig.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.nphew.tes.finalproject_sig.database.Place
import id.nphew.tes.finalproject_sig.databinding.ItemPlaceBinding
import id.nphew.tes.finalproject_sig.helper.TaskDiffCallback

class PlacesAdapter(private val list: List<Place>) :
    ListAdapter<Place,PlacesAdapter.PlaceViewHolder>(TaskDiffCallback<Place>()) {

    private lateinit var binding: id.nphew.tes.finalproject_sig.databinding.ItemPlaceBinding

    class PlaceViewHolder(binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        val textNumber=binding.txtNumber

        fun bind(position: Int) {
            textNumber.text= (position+1).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        binding.place=getItem(position)
        holder.bind(position)
    }
}