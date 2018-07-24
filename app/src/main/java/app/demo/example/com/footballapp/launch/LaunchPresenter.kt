package app.demo.example.com.footballapp.launch

import io.reactivex.disposables.Disposable
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchPresenter(private var view: ISplashView, override var repository: IRepository, private var schedulers: Schedulers) : ISplashPresenter {

    private lateinit var subscription: Disposable

    override fun onCreate() {

    }

    override fun onDestroy() {
        subscription.dispose()
    }
}
