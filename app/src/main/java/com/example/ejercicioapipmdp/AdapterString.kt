package com.example.ejercicioapipmdp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdapterString : RecyclerView.Adapter<AdapterString.StringViewHolder>()  {

    private var datos : List<String>? = null
    private lateinit var recyclerView : RecyclerView

    class StringViewHolder(root: View, val textView: TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.tv_activity_main_item)
        return StringViewHolder(view, textView)
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        datos?.let { cocktailList ->
            holder.textView.text = cocktailList[position].toString()
            holder.root.setOnClickListener{
                val pos = recyclerView.getChildLayoutPosition(it)
                seleccionoCocktail = cocktailList[pos]
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }


    override fun getItemCount(): Int {
        datos?.let {
            return it.size
        }
        return 0
    }

    suspend fun setData(cocktails: List<String>){
        datos = cocktails
        withContext(Dispatchers.Main){
            notifyDataSetChanged()
        }
    }

}