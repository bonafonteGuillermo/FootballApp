package app.demo.example.com.footballapp.repository

import app.demo.example.com.footballapp.model.Area
import io.reactivex.Single


interface IRepository {

    fun getParentAreas(): Single<List<Area>>
    fun getLocallySavedAreasByParentArea(parentArea: Area): Single<List<Area>>
    fun getLocallySavedParentAreas(): List<Area>
    fun saveAreasInLocalStorage(areasList: List<Area>)

}
