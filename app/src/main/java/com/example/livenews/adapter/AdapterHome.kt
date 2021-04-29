package com.example.livenews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livenews.R
import com.example.livenews.model.NewsData

class AdapterHome(val context: Context, val newsArticles:ArrayList<NewsData>): RecyclerView.Adapter<AdapterHome.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.rv_itemview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = newsArticles[position]
        holder.newsTitle.text = article.title
        holder.newsDate.text = article.pulished_at
        if (article.image != null){
            Glide.with(context).load(article.image).into(holder.newsImage)
        }
        if (article.author != null){
            holder.newsSource.text = article.author
        }
        else{
            holder.newsSource.text = "No Source"
        }

    }

    override fun getItemCount(): Int {
        return newsArticles.size
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val newsImage = view.findViewById<ImageView>(R.id.rvNewsImage)
        val newsTitle = view.findViewById<TextView>(R.id.rvNewsTitle)
        val newsSource = view.findViewById<TextView>(R.id.rvNewsSource)
        val newsDate = view.findViewById<TextView>(R.id.rvNewsDate)
    }
}