package com.example.new_app.repo.repositoriesContract.sources

import com.example.new_app.api.model.sourcesResponse.Source

//all interface here >>>


//repo interface
interface SourcesRepository{
    suspend fun getSourceByCategoryId(categoryId:String):List<Source?>?
}
// data class interface > online >> call api to get data
interface SourcesRemoteDataSource
{
    suspend fun  getSourceByCategoryId(categoryId:String):List<Source?>?
}

// data class interface >>offline >>>> room dataBase (cashing)
interface SourcesOfflineDataSource
{
}
