package app.demo.example.com.footballapp.app

import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

/**
 * Created by Guillermo Bonafonte Criado
 */
interface BasePresenter {

    var repository: IRepository
    var schedulers: Schedulers

    fun onCreate()
    fun onDestroy()
}