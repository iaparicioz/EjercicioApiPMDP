package com.example.ejercicioapipmdp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {


    suspend fun getApiResults() : List<Cocktails>? {
        return withContext(Dispatchers.IO) {
            val resultado = GlobalScope.async {
                DownloadManager.downloadApiResults()
            }
            resultado.await()
        }
    }
}