package com.duvivier.clement.services

import com.duvivier.clement.model.People
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface StarWarsService {

    companion object{
        val BASE_URL="https://swapi.dev/api/"
    }

    @GET("people/")
    fun getAllPeople(): Observable<People>

}