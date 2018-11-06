package app.demo.example.com.footballapp.launch

import android.util.Log
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchPresenter(private var view: ILaunchView, override var repository: IRepository, override var schedulers: Schedulers) : ILaunchPresenter {

    var areas : List<Area> = emptyList()

    override fun onCreate() {
        getAreas()
        /*this.areas = areas.toList()
        */
    }

    override fun onDestroy() {}

    override fun itemClicked(item: Area) {
        Log.d("--->", item.parentArea)
    }

    private fun getAreas(): Disposable {
        return repository.getParentAreas()
                .subscribeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { areas ->
                            view.hideLoadingFragment()
                            view.bindViewPager(areas)
                            view.bindTabLayout(areas)
                        },
                        {
                            view.hideLoadingFragment()
                            //TODO Show error dialog or whatever
                        }
                )
    }
}