package app.demo.example.com.footballapp.launch

import android.os.Parcelable
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
class LaunchPresenter(private var view: ILaunchView, override var repository: IRepository, private var schedulers: Schedulers) : ILaunchPresenter {

    private lateinit var subscription: Disposable
    var areas : List<Area> = emptyList()

    override fun onCreate() {

    }

    override fun onCreate(areas: Array<Area>) {
        this.areas = areas.toList()
        view.bindRecyclerViewData(areas.toList())
    }


    override fun onDestroy() {
        subscription.dispose()
    }

    override fun itemClicked(item: Area) {
        Log.d("--->", item.parentArea)
    }
}
