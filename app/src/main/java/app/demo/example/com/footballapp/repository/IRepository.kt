package app.demo.example.com.footballapp.repository

import app.demo.example.com.footballapp.model.Area
import io.reactivex.Single


interface IRepository {

    fun getRemoteAreas(): Single<List<Area>>
    fun getLocalAreas(): List<Area>
    fun saveAreasInLocalStorage(areasList: List<Area>)

}
