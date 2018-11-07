package app.demo.example.com.footballapp.areas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.areas.injection.AreasContextModule
import app.demo.example.com.footballapp.areas.injection.DaggerAreasComponent
import javax.inject.Inject

/**
 *
 * Areas screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class AreasFragment : Fragment() {

    @Inject
    lateinit var view: IAreasView

    @Inject
    lateinit var presenter: IAreasPresenter

    companion object {
        @JvmStatic
        fun newInstance() =
                AreasFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerAreasComponent.builder()
                .appComponent(App.appComponent)
                .areasContextModule(AreasContextModule(activity as AppCompatActivity))
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