package app.demo.example.com.footballapp.repository

import app.demo.example.com.footballapp.model.Area
import io.reactivex.Single


interface IRepository {

    fun getAreas(): Single<List<Area>>

}
