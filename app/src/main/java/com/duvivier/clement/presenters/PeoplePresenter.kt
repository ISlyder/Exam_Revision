package com.duvivier.clement.presenters

import com.duvivier.clement.model.People
import com.duvivier.clement.services.RetrofitBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PeoplePresenter(private val view: PeoplePresenterView) {

    fun getPeople(){
        val peopleService = RetrofitBuilder().getSwService()
            peopleService.getAllPeople()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.listPeople(it)
                },{ error ->
                    view.listError(error)
                })
    }

    interface PeoplePresenterView{
        fun listPeople(people: People)
        fun listError(throwable: Throwable)
    }
}