package app.demo.example.com.footballapp.areas

import android.util.Log
import app.demo.example.com.footballapp.model.Area
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Areas screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class AreasPresenter(private var view: IAreasView, override var repository: IRepository, override var schedulers: Schedulers) : IAreasPresenter {

    private lateinit var subscription: Disposable
    var areas : List<Area> = emptyList()

    override fun onCreate() {
        getAreas()
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
