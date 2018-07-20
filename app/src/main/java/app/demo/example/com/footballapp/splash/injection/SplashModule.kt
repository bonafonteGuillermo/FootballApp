package app.demo.example.com.footballapp.splash.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.splash.*
import app.demo.example.com.footballapp.rx.Schedulers
import app.demo.example.com.footballapp.repository.IRepository
import dagger.Module
import dagger.Provides


/**
 *
 * Dagger module for splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class SplashModule {

    @SplashScope
    @Provides
    fun providePresenter(view: ISplashView, repository: IRepository, schedulers: Schedulers): ISplashPresenter {
        return SplashPresenter(view, repository, schedulers)
    }

    @SplashScope
    @Provides
    fun provideView(context: AppCompatActivity): ISplashView {
        return SplashView(context)
    }

}