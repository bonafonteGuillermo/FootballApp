package app.demo.example.com.footballapp.launch.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.launch.*
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
class LaunchModule {

    @LaunchScope
    @Provides
    fun providePresenter(view: ILaunchView, repository: IRepository, schedulers: Schedulers): ILaunchPresenter {
        return LaunchPresenter(view, repository, schedulers)
    }

    @LaunchScope
    @Provides
    fun provideView(context: AppCompatActivity): ILaunchView {
        return LaunchView(context)
    }

}