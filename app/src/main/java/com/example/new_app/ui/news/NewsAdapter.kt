package com.example.new_app.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.new_app.R
import com.example.new_app.api.model.newsResponse.News
import com.example.new_app.databinding.NewsItemRecyclerBinding
import com.example.new_app.ui.category.CategoryAdapter

class NewsAdapter(var item:List<News?>?):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: NewsItemRecyclerBinding):RecyclerView.ViewHolder(viewBinding.root)
    {
        fun bind(news: News?){
            viewBinding.news=news
            viewBinding.invalidateAll()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var viewBinding=NewsItemRecyclerBinding.inflate(LayoutInflater.from(parent.context)
                ,parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       var items=item?.get(position)
        holder.bind(items)
        //load image by the url > Gilde >>on the bindingAdapter

        onNewsClick?.let {
            holder.viewBinding.NewsLayout.setOnClickListener(View.OnClickListener {
                onNewsClick?.onItemClick( items)
            })
        }

    }

    override fun getItemCount(): Int {
        return item?.size?:0
    }

    fun changeDate(articles: List<News?>?) {
        item=articles
        notifyDataSetChanged()

    }

    var onNewsClick:OnNewsClick?=null
    interface OnNewsClick
    {
        fun onItemClick(news: News?)
    }
}