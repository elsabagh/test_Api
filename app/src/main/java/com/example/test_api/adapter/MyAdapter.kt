package com.example.test_api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test_api.R
import com.example.test_api.model.Post

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title_txt: TextView = itemView.findViewById(R.id.title_txt)
        val id_txt: TextView = itemView.findViewById(R.id.id_txt)
        val userId_txt: TextView = itemView.findViewById(R.id.userId_txt)
        val body_txt: TextView = itemView.findViewById(R.id.body_txt)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userId_txt.text = myList[position].userId.toString()
        holder.id_txt.text = myList[position].id.toString()
        holder.title_txt.text = myList[position].title
        holder.body_txt.text = myList[position].body
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}