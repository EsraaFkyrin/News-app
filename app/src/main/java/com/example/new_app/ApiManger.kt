package com.example.new_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManger {
    companion object{
    var baseUrl="https://newsapi.org/"
   private var retrofit:Retrofit?=null
        @Synchronized private fun getInstance():Retrofit{
            if (retrofit ==null)

            {
                retrofit =Retrofit.Builder().
                baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!! //>> retrofit
        }
//to implement the instance class
        fun getApis(): apiServes {
    // apiinterface : apiinterface=retrofit.creat()>>
           return getInstance().create(apiServes::class.java)
        }


    }
}