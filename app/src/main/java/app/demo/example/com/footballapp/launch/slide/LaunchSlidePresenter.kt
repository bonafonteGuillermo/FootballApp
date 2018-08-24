package app.demo.example.com.footballapp.launch.slide

import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */
class LaunchSlidePresenter(private var view: ILaunchSlideView, override var repository: IRepository, override var schedulers: Schedulers) : ILaunchSlidePresenter {

    override fun onCreate() {}

    override fun onCreate(parentArea: Area, areas: ArrayList<Area>) {
        parentArea.name?.let { view.setParentAreaTitle(it) }
        view.bindRecyclerViewData(areas)
    }

    override fun onDestroy() {
    }
}