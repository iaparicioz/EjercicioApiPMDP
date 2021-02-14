package com.example.ejercicioapipmdp


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class DetailsActivityViewModel : ViewModel() {


    suspend fun getSingleItem(userChoice : String) {
        return withContext(Dispatchers.IO) {
            val resultado = GlobalScope.async {
                DownloadManager.downloadApiSingleResult(userChoice)
            }
            resultado.await()
        }
    }
}


