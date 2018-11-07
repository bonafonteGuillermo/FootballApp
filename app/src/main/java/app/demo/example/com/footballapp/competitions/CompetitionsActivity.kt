package app.demo.example.com.footballapp.competitions

import android.os.Bundle
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.app.BaseActivity
import app.demo.example.com.footballapp.competitions.injection.CompetitionsContextModule
import app.demo.example.com.footballapp.competitions.injection.DaggerCompetitionsComponent

/**
 *
 * Competitions screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class CompetitionsActivity : BaseActivity<ICompetitionsView, ICompetitionsPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerCompetitionsComponent.builder()
                .appComponent(App.appComponent)
                .competitionsContextModule(CompetitionsContextModule(this))
                .build()
                .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(view.constructView())
        view.presenter = presenter
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}