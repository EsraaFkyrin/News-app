package com.example.new_app.ui.categoryDetils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.new_app.ApiManger
import com.example.new_app.api.model.sourcesResponse.Source
import com.example.new_app.api.model.sourcesResponse.SourcesResponse
import com.example.new_app.apiServes
import com.example.new_app.constant
import com.example.new_app.repo.repositoriesContract.sources.SourcesRepository
import com.example.new_app.repo.repositoriesImp.sources.SourcesRemoteDataSourceImpl
import com.example.new_app.repo.repositoriesImp.sources.SourcesRepositoryImpl
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CategoryDetailsViewModel : ViewModel() {

    var showLoading = MutableLiveData<Boolean>()
    var showTabLayout = MutableLiveData<Boolean>()
    var sourceLiveData = MutableLiveData<List<Source?>?>()
    var showErrorLayout = MutableLiveData<String>()
    // manual dependency injection

    var remoteDataSource=SourcesRemoteDataSourceImpl(ApiManger.getApis())
    //obj of type repo
    var sourcesRepository:SourcesRepository=SourcesRepositoryImpl(remoteDataSource)

    fun loadApi(categoryId: String) {
        //run the loading bar and hide the text and btn
        showLoading.value = true
        //call api

        viewModelScope.launch {
            try {
                var sources =sourcesRepository.getSourceByCategoryId(categoryId)
                showTabLayout.value = true
                showLoading.value = false
                sourceLiveData.value = (sources)
            } catch (e: HttpException) {
                //convert gson (error body) to response message
                var gson = Gson()
                var errorResponse = gson
                    .fromJson(e.response()?.errorBody()?.string(), SourcesResponse::class.java)

                //fun to show error on the txt after convert error body
                showErrorLayout.value = errorResponse.message ?: ""

            }
            catch (e:Exception)
            {
                showErrorLayout.value=e.localizedMessage
            }
        }
//            .getApis()
//            .getSources(constant.apiKay, categoryId)
//            .enqueue(object : Callback<SourcesResponse> {
//                override fun onResponse(
//                    call: Call<SourcesResponse>,
//                    response: Response<SourcesResponse>
//                ) {
//                    if (response.isSuccessful) {
//                       showTabLayout.value=true
//                        showLoading.value=false
//
//                        //func to show sources on the tap
//                      sourceLiveData.value=  (response.body()?.sources)
//                    } else {
//                        //convert gson (error body) to response message
//                        var gson = Gson()
//                        var errorResponse = gson
//                            .fromJson(response.errorBody()?.string(), SourcesResponse::class.java)
//
//                        //fun to show error on the txt after convert error body
//                        showErrorLayout.value=errorResponse.message?:""
//                    }
//                }
//
//                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
//
//                    showErrorLayout.value=t.localizedMessage
//
//                }
//
//            })


    }

}