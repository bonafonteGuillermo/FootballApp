package app.demo.example.com.footballapp.competitions

import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Competitions screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class CompetitionsPresenter(private var view: ICompetitionsView, override var repository: IRepository, override var schedulers: Schedulers) : ICompetitionsPresenter {

    private lateinit var subscription: Disposable

    override fun onCreate() {

    }

    override fun onDestroy() {
        subscription.dispose()
    }
}
