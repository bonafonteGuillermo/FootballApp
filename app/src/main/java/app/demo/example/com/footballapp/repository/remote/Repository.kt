package app.demo.example.com.footballapp.repository.remote

import android.annotation.SuppressLint
import android.content.SharedPreferences
import app.demo.example.com.footballapp.data.AppDatabase
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.Api
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import app.demo.example.com.footballapp.utils.getFootballDataApiToken
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject

class Repository(private val api: Api,
                 private val localStorage: AppDatabase,
                 private val schedulers: Schedulers,
                 private val preferences: SharedPreferences
) : IRepository {

    //region RemoteRequest
    @SuppressLint("CheckResult")
    override fun getParentAreas(): Single<List<Area>> {

        var publisher = SingleSubject.create<List<Area>>()

        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                {
                    val parentAreasLocallySaved = getLocallySavedParentAreas()
                    if (parentAreasLocallySaved.isEmpty()) {
                        var response = api.getAreas(getFootballDataApiToken())
                        response.subscribe(
                                {
                                    saveAreasInLocalStorage(it.areas)
                                    publisher.onSuccess(getLocallySavedParentAreas())
                                },
                                {   publisher.onError(it) }
                        )
                    } else {
                        publisher.onSuccess(parentAreasLocallySaved)
                    }
                },
                { publisher.onError(it) }
        )
        return publisher
    }
    //endregion

    //region LocaleStorage
    @SuppressLint("CheckResult")
    override fun getLocallySavedAreasByParentArea(parentArea: Area): Single<List<Area>> {
        var publisher = SingleSubject.create<List<Area>>()
        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                {
                    publisher.onSuccess(it.areasDao().getAreas(parentArea.parentArea.toString()))
                },
                {
                    publisher.onError(it)
                })
        return publisher
    }

    override fun getLocallySavedParentAreas(): List<Area> = localStorage.areasDao().getGroupedAreas()

    override fun saveAreasInLocalStorage(areasList: List<Area>) {
        for (area in areasList) {
            localStorage.areasDao().insertArea(area)
        }
    }
    //endregion
}