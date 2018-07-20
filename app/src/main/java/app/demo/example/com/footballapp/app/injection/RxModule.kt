package app.demo.example.com.footballapp.app.injection

import dagger.Module
import dagger.Provides
import app.demo.example.com.footballapp.rx.Schedulers
import app.demo.example.com.footballapp.rx.AppSchedulers

/**
 *
 * Dagger module for Rx schedulers
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RxModule {

    @Provides
    fun provideRxSchedulers(): Schedulers {
        return AppSchedulers()
    }
}