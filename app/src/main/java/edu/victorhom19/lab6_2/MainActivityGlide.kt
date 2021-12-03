package edu.victorhom19.lab6_2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.concurrent.ExecutorService
import android.graphics.BitmapFactory
import com.bumptech.glide.Glide
import java.net.URL
import java.util.concurrent.Executors


class MainActivityGlide: AppCompatActivity() {
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image)
        Glide.with(this).load(url).into(imageView)
    }

    companion object {
        private const val url = "https://static.wikia.nocookie.net/dota2_gamepedia/images/c/c0/Pudge_icon.png/revision/latest?cb=20160411211506"
    }

}