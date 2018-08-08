package app.demo.example.com.footballapp.launch

import android.util.Log
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchPresenter(private var view: ISplashView, override var repository: IRepository, private var schedulers: Schedulers) : ISplashPresenter {

    private lateinit var subscription: Disposable

    override fun onCreate() {
        getAreas()
    }

    override fun onDestroy() {
        subscription.dispose()
    }

    fun getAreas(): Disposable {
        return repository.getRemoteAreas()
                .subscribeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        {
                            areas ->
                            for (a in areas){
                                Log.d("--->", a.name)
                            }
                        },
                        {

                        }
                )
    }
}
