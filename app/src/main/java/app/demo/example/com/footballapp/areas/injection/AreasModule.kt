package app.demo.example.com.footballapp.areas.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.areas.IAreasPresenter
import app.demo.example.com.footballapp.areas.IAreasView
import app.demo.example.com.footballapp.areas.AreasPresenter
import app.demo.example.com.footballapp.areas.AreasView
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for areas screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class AreasModule {

    @AreasScope
    @Provides
    fun providePresenter(view: IAreasView, repository: IRepository, schedulers: Schedulers): IAreasPresenter {
        return AreasPresenter(view, repository, schedulers)
    }

    @AreasScope
    @Provides
    fun provideView(context: AppCompatActivity): IAreasView {
        return AreasView(context)
    }

}