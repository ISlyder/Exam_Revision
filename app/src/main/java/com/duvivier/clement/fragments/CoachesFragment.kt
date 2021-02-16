package com.duvivier.clement.fragments

import RecyclerCoach
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duvivier.clement.DetailActivity
import com.duvivier.clement.R
import com.duvivier.clement.model.Coach
import com.duvivier.clement.services.LakerService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CoachesFragment : Fragment() {
    private val liste: ArrayList<Coach> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_coaches, container, false)

      /* val recyclerCoach = rootView.findViewById<RecyclerView>(R.id.recylcerCoach)
        recyclerCoach.adapter=RecyclerCoach(liste, context!!){
            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }
        recyclerCoach.layoutManager = LinearLayoutManager(context)

        val service = Retrofit.Builder()
            .baseUrl(LakerService.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LakerService::class.java)

        service.getPlayers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liste.addAll(it.coach)
                recyclerCoach.adapter?.notifyDataSetChanged()
            },{
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            })*/

        // Inflate the layout for this fragment
        return rootView
    }

}