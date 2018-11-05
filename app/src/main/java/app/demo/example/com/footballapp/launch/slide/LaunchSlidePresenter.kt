package app.demo.example.com.footballapp.launch.slide

import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.Observable

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */
class LaunchSlidePresenter(private var view: ILaunchSlideView, override var repository: IRepository, override var schedulers: Schedulers) : ILaunchSlidePresenter {

    override fun onCreate() {}

    override fun onCreate(parentArea: Area) {
        repository.getLocallySavedAreasByParentArea(parentArea)
                .subscribeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { areas ->
                            view.hideLoadingFragment()
                            view.bindRecyclerViewData(areas)
                        },
                        {
                            view.hideLoadingFragment()
                            //TODO Show error dialog or whatever
                        }
                )
    }

    override fun onDestroy() {
    }
}