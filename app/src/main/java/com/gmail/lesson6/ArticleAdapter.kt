package com.gmail.lesson6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ArticleAdapter(
    val context: Context, val articleSource:List<ArticleInfo>)
    : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){
    var onItemClick: ((ArticleInfo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_article,parent,false))
    }

    override fun getItemCount(): Int {
        return articleSource.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = articleSource[position].title
        Picasso.get().load(articleSource[position].imageURL).into(holder.itemImage)
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemText = view.findViewById<TextView>(R.id.itemText)
        val itemImage = view.findViewById<ImageView>(R.id.itemImage)
        init{
            view.setOnClickListener{
                onItemClick?.invoke(articleSource[adapterPosition])
            }
        }
    }
}
