package app.demo.example.com.footballapp.app.injection

import android.content.SharedPreferences
import app.demo.example.com.footballapp.data.AppDatabase
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers
import dagger.Component
import javax.inject.Singleton

/**
 *
 * Dagger component for app
 *
 * Created by Guillermo Bonafonte Criado
 */
@Singleton
@AppScope
@Component(modules = [
    (ApiModule::class),
    (AppContextModule::class),
    (NetworkingModule::class),
    (RepositoryModule::class),
    (RxModule::class),
    (SharedPreferencesModule::class),
    (DatabaseModule::class)]
)

interface AppComponent {

    fun rxSchedulers(): Schedulers
    fun repository(): IRepository
    fun sharedPreferences(): SharedPreferences
    fun database(): AppDatabase

}