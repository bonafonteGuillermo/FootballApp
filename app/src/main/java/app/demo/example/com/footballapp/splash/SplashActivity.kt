package app.demo.example.com.footballapp.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.app.App
import app.demo.example.com.footballapp.splash.injection.DaggerSplashComponent
import app.demo.example.com.footballapp.splash.injection.SplashContextModule

import javax.inject.Inject

/**
 *
 * Splash screen.ore proceeding.
 *
 * Created by Guillermo Bonafonte Criado
 */
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var view: ISplashView

    @Inject
    lateinit var presenter: ISplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSplashComponent.builder()
                .appComponent(App.appComponent)
                .splashContextModule(SplashContextModule(this))
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
