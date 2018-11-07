package app.demo.example.com.footballapp.areas.slide.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.areas.slide.ILaunchSlidePresenter
import app.demo.example.com.footballapp.areas.slide.ILaunchSlideView
import app.demo.example.com.footballapp.areas.slide.AreasSlidePresenter
import app.demo.example.com.footballapp.areas.slide.AreasSlideView
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
class AreasSlideModule {

    @AreasSlideScope
    @Provides
    fun providesLaunchSlidePresenter(view : ILaunchSlideView, repository : IRepository, schedulers: Schedulers): ILaunchSlidePresenter {
        return AreasSlidePresenter(view, repository, schedulers)
    }

    @AreasSlideScope
    @Provides
    fun providesLaunchSlideView(context : AppCompatActivity) : ILaunchSlideView {
        return AreasSlideView(context)
    }
}