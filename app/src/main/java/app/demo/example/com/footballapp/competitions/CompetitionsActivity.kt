package app.demo.example.com.footballapp.competitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.competitions.injection.DaggerCompetitionsComponent
import app.demo.example.com.footballapp.competitions.injection.CompetitionsContextModule

import javax.inject.Inject

/**
 *
 * Competitions screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class CompetitionsActivity : AppCompatActivity() {

    @Inject
    lateinit var view: ICompetitionsView

    @Inject
    lateinit var presenter: ICompetitionsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerCompetitionsComponent.builder()
                .appComponent(App.appComponent)
                .competitionsContextModule(CompetitionsContextModule(this))
                .build()
                .inject(this)


        setContentView(view.constructView())
        view.presenter = presenter

        presenter.onCreate()

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
