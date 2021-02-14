package com.example.ejercicioapipmdp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioapipmdp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var model :MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    private var adapter = AdapterString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        createRecyclerView()

        GlobalScope.launch(Dispatchers.IO) {
            val resultados : List<String> = listOf(model.getApiResults().toString())
            adapter.setData(resultados)
            hideProgressBar()
        }

        binding.bSiguiente.setOnClickListener {
            DetailsActivity.createDetailsActivity(this)
        }

    }


    private suspend fun hideProgressBar() = withContext(Dispatchers.Main) {
        binding.progressBar2.visibility = View.GONE
    }

    private fun createRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}