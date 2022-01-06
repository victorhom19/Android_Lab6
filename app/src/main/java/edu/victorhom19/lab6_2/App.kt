package edu.victorhom19.lab6_2

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class App: Application() {
    val executor: ExecutorService = Executors.newFixedThreadPool(1)
}