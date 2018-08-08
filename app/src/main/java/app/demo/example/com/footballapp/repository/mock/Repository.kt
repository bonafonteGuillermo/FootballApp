package app.demo.example.com.footballapp.repository.mock

import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import io.reactivex.Single

class Repository : IRepository {
    override fun getRemoteAreas(): Single<List<Area>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocalAreas(): List<Area> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAreasInLocalStorage(areasList: List<Area>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}