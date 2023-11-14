package com.example.new_app.repo.repositoriesImp.news

import com.example.new_app.api.model.newsResponse.News
import com.example.new_app.apiServes
import com.example.new_app.constant
import com.example.new_app.repo.repositoriesContract.news.NewsRemoteDataSources

class NewsRemoteDataSourcesImpl(var apiServes: apiServes) :NewsRemoteDataSources {
    override suspend fun getNewsBySourceId(sourceId: String, pageSize: Int, page: Int): List<News?>? {
var news=apiServes.getNews(constant.apiKay,sourceId,pageSize,page)
    return news.articles
    }

}