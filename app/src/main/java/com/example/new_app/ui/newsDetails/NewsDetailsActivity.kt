package com.example.new_app.ui.newsDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.new_app.R
import com.example.new_app.api.model.newsResponse.News
import com.example.new_app.databinding.ActivityNewsDetailsBinding


class NewsDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivityNewsDetailsBinding
    private lateinit var news: News
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=DataBindingUtil.setContentView(this,R.layout.activity_news_details)
             news=((intent.getSerializableExtra("news") as? News)!!)
        viewBinding.newsData= news


    }
}