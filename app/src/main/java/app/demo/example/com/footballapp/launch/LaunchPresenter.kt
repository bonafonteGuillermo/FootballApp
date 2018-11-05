package app.demo.example.com.footballapp.launch

import android.util.Log
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchPresenter(private var view: ILaunchView, override var repository: IRepository, override var schedulers: Schedulers) : ILaunchPresenter {

    var areas : List<Area> = emptyList()

    override fun onCreate() {}

    override fun onCreate(areas: ArrayList<Area>) {
        this.areas = areas.toList()
        view.bindViewPager(areas)
        view.bindTabLayout(areas)
    }

    override fun onDestroy() {}

    override fun itemClicked(item: Area) {
        Log.d("--->", item.parentArea)
    }
}