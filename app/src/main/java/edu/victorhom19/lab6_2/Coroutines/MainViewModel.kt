package edu.victorhom19.lab6_2.Coroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<Bitmap>(null)

    fun downloadImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val url = URL(url)
            val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            withContext(Dispatchers.Main) { liveData.value = image }
        }
    }

    companion object {
        private const val url = "https://static.wikia.nocookie.net/dota2_gamepedia/images/c/c0/Pudge_icon.png/revision/latest?cb=20160411211506"
    }
}