package app.demo.example.com.footballapp.competitions.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.competitions.ICompetitionsPresenter
import app.demo.example.com.footballapp.competitions.ICompetitionsView
import app.demo.example.com.footballapp.competitions.CompetitionsFragmentPresenter
import app.demo.example.com.footballapp.competitions.CompetitionsFragmentView
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for competitions screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class CompetitionsModule {

    @CompetitionsScope
    @Provides
    fun providePresenter(view: ICompetitionsView, repository: IRepository, schedulers: Schedulers): ICompetitionsPresenter {
        return CompetitionsFragmentPresenter(view, repository, schedulers)
    }

    @CompetitionsScope
    @Provides
    fun provideView(context: AppCompatActivity): ICompetitionsView {
        return CompetitionsFragmentView(context)
    }

}