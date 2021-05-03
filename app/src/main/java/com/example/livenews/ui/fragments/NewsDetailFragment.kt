package com.example.livenews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.livenews.R
import com.example.livenews.ui.MainActivity
import com.example.livenews.viewModel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_news_detail.*


class NewsDetailFragment : Fragment() {

    val args :NewsDetailFragmentArgs by navArgs()
    lateinit var viewmodel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = args.article
        detailtextTitle.text = article.title
        detailTextDetail.text = article.description
        Glide.with(this).load(article.image).into(detailImageview)

        viewmodel = ViewModelProvider(this).get(NewsViewModel::class.java)

        /**
         * Checing if data is coming from database
         */
        if(article.id != 0){
            addtofav.setOnClickListener {
                viewmodel.deleteNews(article)
                Snackbar.make(view,"Article deleted successfully",Snackbar.LENGTH_SHORT).show()
            }
        }
        /**
         *Checking if data is coming from API
         */
        else {
            addtofav.setOnClickListener {
                viewmodel.insertNews(article)
                Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}