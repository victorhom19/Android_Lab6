package edu.victorhom19.lab6_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.concurrent.ExecutorService
import android.graphics.BitmapFactory
import java.net.URL
import java.util.concurrent.Executors


class MainActivityExecutionService : AppCompatActivity() {
    private lateinit var imageView : ImageView
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image)
        executorService.execute {
            val url = URL(url)
            val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread { imageView.setImageBitmap(image) }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        executorService.shutdown()
    }
    companion object {
        private const val url = "https://static.wikia.nocookie.net/dota2_gamepedia/images/c/c0/Pudge_icon.png/revision/latest?cb=20160411211506"
    }

}