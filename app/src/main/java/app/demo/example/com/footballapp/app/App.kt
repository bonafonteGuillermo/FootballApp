package app.demo.example.com.footballapp.app

import android.app.Application

import app.demo.example.com.footballapp.app.injection.AppComponent
import app.demo.example.com.footballapp.app.injection.DaggerAppComponent
import app.demo.example.com.footballapp.app.injection.AppContextModule

/**
 *
 * App instance, it will be a singleton along the lifecycle.
 *
 * Created by Guillermo Bonafonte Criado
 */
class App : Application() {

    companion object {
        val TAG = "App"
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }
}