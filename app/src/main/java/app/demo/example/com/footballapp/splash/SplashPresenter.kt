package app.demo.example.com.footballapp.splash

import android.content.Intent
import app.demo.example.com.footballapp.launch.LaunchActivity
import android.os.Bundle
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
class SplashPresenter(private var view: ISplashView, override var repository: IRepository, private var schedulers: Schedulers) : ISplashPresenter {

    private lateinit var subscription: Disposable
    private val handler : Handler = Handler()

    override fun onCreate() {
        view.showLoadingFragment()
        handler.postDelayed({
            getAreas()
        },3000)
    }

    override fun onDestroy() {
        subscription.dispose()
    }

    private fun getAreas(): Disposable {
        return repository.getAreas()
                .subscribeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { areas ->
                            view.hideLoadingFragment()

                            /*var intent = Intent()
                            intent.putParcelableArrayListExtra("areas",areas.toTypedArray())*/
                            view.startActivity(LaunchActivity::class.java, bundle)
                        },
                        {
                            view.hideLoadingFragment()
                            //TODO Show error dialog or whatever
                        }
                )
    }
}
