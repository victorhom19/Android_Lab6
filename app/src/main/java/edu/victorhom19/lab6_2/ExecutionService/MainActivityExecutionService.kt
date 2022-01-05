package edu.victorhom19.lab6_2.ExecutionService


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.concurrent.ExecutorService
import android.graphics.BitmapFactory
import edu.victorhom19.lab6_2.R
import java.net.URL


class MainActivityExecutionService : AppCompatActivity() {
    private lateinit var executorService: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executorService = ExecutorInstance().executor
        executorService.execute {
            val url = URL(url)
            val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread { findViewById<ImageView>(R.id.image).setImageBitmap(image) }
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