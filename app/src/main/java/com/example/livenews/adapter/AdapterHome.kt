package com.example.livenews.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livenews.R
import com.example.livenews.model.NewsData



class AdapterHome(val context: Context,val data:ArrayList<NewsData>): RecyclerView.Adapter<AdapterHome.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_itemview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = data[position]
        holder.itemView.apply {
            holder.newsTitle.text = article.title
            holder.newsDate.text = article.pulished_at.substring(0,10)
            if (article.image != null){
                Glide.with(this).load(article.image).into(holder.newsImage)
            }
            if (article.author != null){
                holder.newsSource.text = article.author
            }
            else{
                holder.newsSource.text = "No Source"
            }
            setOnClickListener {
                val bundle = Bundle().apply {
                    putSerializable("article",article)
                }
                findNavController().navigate(R.id.action_homePageFragment_to_newsDetailFragment,bundle)
            }
        }


    }

    override fun getItemCount(): Int {

        return data.size
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val newsImage = view.findViewById<ImageView>(R.id.rvNewsImage)
        val newsTitle = view.findViewById<TextView>(R.id.rvNewsTitle)
        val newsSource = view.findViewById<TextView>(R.id.rvNewsSource)
        val newsDate = view.findViewById<TextView>(R.id.rvNewsDate)
    }


}