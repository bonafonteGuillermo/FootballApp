package app.demo.example.com.footballapp.splash

import app.demo.example.com.footballapp.app.BasePresenter
import app.demo.example.com.footballapp.app.BaseView
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Contracts for splash view and splash presenter
 *
 * Created by Guillermo Bonafonte Criado
 */
interface ISplashPresenter : BasePresenter {

}

interface ISplashView : BaseView<ISplashPresenter> {
    fun  navigateToLaunchActivity(areas:List<Area>)

}