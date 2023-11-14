package com.example.new_app.repo.repositoriesContract.news

import com.example.new_app.api.model.newsResponse.News

interface NewsRepository{
    suspend fun getNewsBySourceId(sourceId:String,pageSize:Int,page:Int):List<News?>?
}
interface NewsRemoteDataSources{
    suspend fun getNewsBySourceId(sourceId:String,pageSize:Int,page:Int):List<News?>?
}
interface NewsLocalDataSources{

}