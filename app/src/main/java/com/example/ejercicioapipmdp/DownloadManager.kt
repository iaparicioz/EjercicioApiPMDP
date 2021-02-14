package com.example.ejercicioapipmdp

import android.util.Log

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import okhttp3.*
import org.json.JSONArray


class DownloadManager {

    companion object {
        suspend fun downloadApiResults(): List<Cocktails>? {
            // CONEXION A INTERNET
            // OKHTTP....
            val client = OkHttpClient()
            val url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita"

            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            val response = call.execute()
            val bodyInString = response.body?.string()
            var aer = bodyInString?.let {
                Log.w("GetCocktails", bodyInString)
                val results = JSONArray(bodyInString)

                results?.let {
                    Log.w("GetCocktails", results.toString())
                    val gson = Gson()

                    val itemType = object : TypeToken<List<Cocktails>>() {}.type

                    val list = gson.fromJson<List<Cocktails>>(results.toString(), itemType)

                    return@let list
                }
            }
            return aer


        }
        suspend fun downloadApiSingleResult(userChoice : String) : String {
            // CONEXION A INTERNET
            // OKHTTP....
            delay(3000)
            return when (userChoice.length) {
                1 -> "RESULTADO 1"
                2 -> "RESULTADO 2"
                else -> "OTROS RESULTADOS"
            }
        }
    }
}





