package com.duvivier.clement.services

import com.duvivier.clement.model.Equipe
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface LakerService {

    companion object{
        val BASE_URL="https://android.busin.fr/api/"
    }

    @GET("lakers/")
    fun getPlayers(): Observable<Equipe>

}