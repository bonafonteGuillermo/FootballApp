package app.demo.example.com.footballapp.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 *
 * Shared schedulers provider
 *
 */
class AppSchedulers : Schedulers {

    var internetExecutor: Executor = Executors.newCachedThreadPool()
    var INTERNET_SCHEDULERS = io.reactivex.schedulers.Schedulers.from(internetExecutor)

    override fun io(): Scheduler {
        return io.reactivex.schedulers.Schedulers.io()
    }

    override fun androidThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun internet(): Scheduler {
        return INTERNET_SCHEDULERS
    }

}

