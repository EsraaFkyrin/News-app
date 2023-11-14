package com.example.new_app.repo.repositoriesImp.sources

import com.example.new_app.api.model.sourcesResponse.Source
import com.example.new_app.apiServes
import com.example.new_app.constant
import com.example.new_app.repo.repositoriesContract.sources.SourcesRemoteDataSource

class SourcesRemoteDataSourceImpl(var apiServes: apiServes):SourcesRemoteDataSource {
    override suspend fun getSourceByCategoryId(categoryId: String): List<Source?>? {
       var sourceResponse= apiServes.getSources(constant.apiKay,categoryId)
    return sourceResponse.sources
    }

}