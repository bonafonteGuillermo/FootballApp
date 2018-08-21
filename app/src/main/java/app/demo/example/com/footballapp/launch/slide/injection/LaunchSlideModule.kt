package app.demo.example.com.footballapp.launch.slide.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.launch.ILaunchView
import app.demo.example.com.footballapp.launch.LaunchPresenter
import app.demo.example.com.footballapp.launch.slide.ILaunchSlidePresenter
import app.demo.example.com.footballapp.launch.slide.ILaunchSlideView
import app.demo.example.com.footballapp.launch.slide.LaunchSlidePresenter
import app.demo.example.com.footballapp.launch.slide.LaunchSlideView
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

@Module
class LaunchSlideModule {

    @LaunchSlideScope
    @Provides
    fun providesLaunchSlidePresenter(view : ILaunchSlideView, repository : IRepository, schedulers: Schedulers): ILaunchSlidePresenter {
        return LaunchSlidePresenter(view, repository, schedulers)
    }

    @LaunchSlideScope
    @Provides
    fun providesLaunchSlideView(context : AppCompatActivity) : ILaunchSlideView {
        return LaunchSlideView(context)
    }
}