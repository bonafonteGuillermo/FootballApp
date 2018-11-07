package app.demo.example.com.footballapp.competitions

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.app.BaseActivity
import app.demo.example.com.footballapp.areas.AreasFragment
import app.demo.example.com.footballapp.areas.IAreasPresenter
import app.demo.example.com.footballapp.areas.IAreasView
import app.demo.example.com.footballapp.competitions.injection.CompetitionsContextModule
import app.demo.example.com.footballapp.competitions.injection.DaggerCompetitionsComponent
import javax.inject.Inject

/**
 *
 * Competitions screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class CompetitionsFragment : Fragment() {

    @Inject
    lateinit var view: ICompetitionsView

    @Inject
    lateinit var presenter: ICompetitionsPresenter

    companion object {
        @JvmStatic
        fun newInstance() =
                CompetitionsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerCompetitionsComponent.builder()
                .appComponent(App.appComponent)
                .competitionsContextModule(CompetitionsContextModule(activity as AppCompatActivity))
                .build()
                .inject(this)

        view.presenter = presenter
        presenter.onCreate()
        return view.constructView()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}