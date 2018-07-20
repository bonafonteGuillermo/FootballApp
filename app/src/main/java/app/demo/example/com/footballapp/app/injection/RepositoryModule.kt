package app.demo.example.com.footballapp.app.injection

import android.content.SharedPreferences
import app.demo.example.com.footballapp.data.AppDatabase
import app.demo.example.com.footballapp.repository.Api
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.repository.mock.Repository as MockRepository
import app.demo.example.com.footballapp.repository.remote.Repository as RemoteRepository
import dagger.Module
import dagger.Provides
import app.demo.example.com.footballapp.rx.Schedulers
import app.demo.example.com.footballapp.utils.Configuration

/**
 * Created by Guillermo Bonafonte Criado
 */
@Module
class RepositoryModule {

    @AppScope
    @Provides
    fun provideRepository(api: Api, localStorage: AppDatabase, schedulers: Schedulers, preferences: SharedPreferences): IRepository =
        when (Configuration().Environment) {
            Configuration.Variant.MOCK -> MockRepository()
            else -> RemoteRepository(api, localStorage, schedulers, preferences)
        }
}