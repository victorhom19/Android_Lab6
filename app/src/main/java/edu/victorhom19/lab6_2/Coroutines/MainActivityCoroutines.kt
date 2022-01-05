package edu.victorhom19.lab6_2.Coroutines


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

import androidx.activity.viewModels
import edu.victorhom19.lab6_2.R


class MainActivityCoroutines : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel : MainViewModel by viewModels()
        val imageView : ImageView = findViewById(R.id.image)
        viewModel.liveData.observe(
            this, { bitmap ->
                if (bitmap == null) viewModel.downloadImage()
                else imageView.setImageBitmap(bitmap)
            }
        )
    }
}