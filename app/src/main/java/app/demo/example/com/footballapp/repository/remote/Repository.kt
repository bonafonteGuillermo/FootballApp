package app.demo.example.com.footballapp.repository.remote

import android.content.SharedPreferences
import app.demo.example.com.footballapp.data.AppDatabase
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.Api
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import app.demo.example.com.footballapp.utils.getFootballDataApiToken
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject

class Repository(private val api: Api,
                 private val localStorage: AppDatabase,
                 private val schedulers: Schedulers,
                 private val preferences: SharedPreferences
) : IRepository {


    override fun getAreas(): Single<List<Area>> {

        var publisher = SingleSubject.create<List<Area>>()

        var areas = api.getAreas(getFootballDataApiToken())
        areas.subscribe(
                { areasResponse -> publisher.onSuccess(areasResponse.areas) },
                { error -> publisher.onError(error) }
        )
        return publisher
    }


}