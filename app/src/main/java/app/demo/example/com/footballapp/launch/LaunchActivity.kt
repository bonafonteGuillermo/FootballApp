package app.demo.example.com.footballapp.launch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.launch.injection.DaggerLaunchComponent
import app.demo.example.com.footballapp.launch.injection.LaunchContextModule

import javax.inject.Inject

/**
 *
 * Splash screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class LaunchActivity : AppCompatActivity() {

    @Inject
    lateinit var view: ILaunchView

    @Inject
    lateinit var presenter: ILaunchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerLaunchComponent.builder()
                .appComponent(App.appComponent)
                .launchContextModule(LaunchContextModule(this))
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
