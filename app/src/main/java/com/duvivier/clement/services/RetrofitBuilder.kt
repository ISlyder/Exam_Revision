package com.duvivier.clement.services

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitBuilder {

    fun getSwService(): StarWarsService{
        return Retrofit.Builder()
            .baseUrl(StarWarsService.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsService::class.java)
    }
}