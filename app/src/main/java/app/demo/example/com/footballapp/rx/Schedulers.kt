package app.demo.example.com.footballapp.rx

import io.reactivex.Scheduler

/**
 *
 * Shared schedulers specification
 *
 * Created by Jorge Para on 10/30/17.
 * 2017 © Cognizant Technology Solutions
 */
interface Schedulers {

    fun io(): Scheduler

    fun androidThread(): Scheduler

    fun internet(): Scheduler

}