package app.demo.example.com.footballapp.repository.mock

import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import io.reactivex.Single

class Repository : IRepository {
    override fun getLocallySavedParentAreas(): List<Area> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAreas(): Single<List<Area>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocallySavedAreasByParentArea(parentAreaName: String): List<Area> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAreasInLocalStorage(areasList: List<Area>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}