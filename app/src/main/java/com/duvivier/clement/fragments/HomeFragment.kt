package com.duvivier.clement.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duvivier.clement.R
import com.duvivier.clement.adapters.RecyclerAdapter
import com.duvivier.clement.model.Nom
import com.duvivier.clement.model.People
import com.duvivier.clement.presenters.PeoplePresenter
import com.duvivier.clement.services.StarWarsService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment(), PeoplePresenter.PeoplePresenterView {
    private val mots: ArrayList<Nom> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val recycler = rootView.findViewById<RecyclerView>(R.id.recylcer)
        recycler.adapter=RecyclerAdapter(mots)
        recycler.layoutManager = LinearLayoutManager(context)

        /*A la bourrin*/
        /*val service = Retrofit.Builder()
            .baseUrl(StarWarsService.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsService::class.java)

        service.getAllPeople()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mots.addAll(it)
                recycler.adapter?.notifyDataSetChanged()
            },{
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            })*/

        /*Clean*/
        val presenter = PeoplePresenter(this)
        presenter.getPeople()

        // Inflate the layout for this fragment
        return rootView
    }

    override fun listPeople(people : People) {
        people.results.forEach{
            mots.add(it)
        }
        recylcer.adapter?.notifyDataSetChanged()
    }

    override fun listError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
    }


}