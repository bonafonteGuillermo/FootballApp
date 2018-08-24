package app.demo.example.com.footballapp.repository.remote

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
    override fun getAreas(): Single<List<Area>> {

        var publisher = SingleSubject.create<List<Area>>()

        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                { db ->
                    val areasLocallySaved = getLocallySavedParentAreas()
                    if (areasLocallySaved.isEmpty()) {
                        var response = api.getAreas(getFootballDataApiToken())
                        response.subscribe(
                                { areasResponse ->
                                    saveAreasInLocalStorage(areasResponse.areas)
                                    publisher.onSuccess(getLocallySavedParentAreas())
                                },
                                { error ->
                                    publisher.onError(error)
                                }
                        )
                    } else {
                        publisher.onSuccess(areasLocallySaved)
                    }
                },
                { error ->
                    publisher.onError(error)
                }
        )
        return publisher
    }
    //endregion

    //region LocaleStorage
    override fun getLocallySavedAreasByParentArea(parentAreaName : String): List<Area> = localStorage.areasDao().getAreas(parentAreaName)

    override fun getLocallySavedParentAreas(): List<Area> = localStorage.areasDao().getGroupedAreas()

    override fun saveAreasInLocalStorage(areasList: List<Area>) {
        for (area in areasList) {
            localStorage.areasDao().insertArea(area)
        }
    }
    //endregion
}