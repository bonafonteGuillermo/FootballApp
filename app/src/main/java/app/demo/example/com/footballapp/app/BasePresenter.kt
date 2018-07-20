package app.demo.example.com.footballapp.app

import app.demo.example.com.footballapp.repository.IRepository
/**
 * Created by Guillermo Bonafonte Criado
 */
interface BasePresenter {

    var repository: IRepository

    fun onCreate()
    fun onDestroy()
}