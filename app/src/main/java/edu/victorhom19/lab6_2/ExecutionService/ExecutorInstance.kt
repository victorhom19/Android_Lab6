package edu.victorhom19.lab6_2.ExecutionService

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ExecutorInstance: Application() {
    val executor: ExecutorService = Executors.newFixedThreadPool(1)
}