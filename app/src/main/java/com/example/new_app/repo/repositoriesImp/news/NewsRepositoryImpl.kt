package com.example.new_app.repo.repositoriesImp.news

import com.example.new_app.api.model.newsResponse.News
import com.example.new_app.repo.repositoriesContract.news.NewsRemoteDataSources
import com.example.new_app.repo.repositoriesContract.news.NewsRepository

class NewsRepositoryImpl(var newsRemoteDataSources: NewsRemoteDataSources) :NewsRepository {
    override suspend fun getNewsBySourceId(
        sourceId: String,
        pageSize: Int,
        page: Int
    ): List<News?>? {
     var data =newsRemoteDataSources.getNewsBySourceId(sourceId,pageSize,page)
    return data
    }


}