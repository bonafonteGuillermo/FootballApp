package app.demo.example.com.footballapp.splash

import android.os.Handler
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class SplashPresenter(private var view: ISplashView, override var repository: IRepository, override var schedulers: Schedulers) : ISplashPresenter {

    private lateinit var subscription: Disposable
    private val handler : Handler = Handler()

    override fun onCreate() {
        view.showLoadingFragment()
        handler.postDelayed({
            subscription = getAreas()
        },3000)
    }

    override fun onDestroy() {
//        subscription?.dispose()
    }

    private fun getAreas(): Disposable {
        return repository.getParentAreas()
                .subscribeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { areas ->
                            view.hideLoadingFragment()
                            view.navigateToLaunchActivity(areas)
                        },
                        {
                            view.hideLoadingFragment()
                            //TODO Show error dialog or whatever
                        }
                )
    }
}
