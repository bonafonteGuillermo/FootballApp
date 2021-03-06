package app.demo.example.com.footballapp.app.injection

import app.demo.example.com.footballapp.data.AppDatabase
import android.arch.persistence.room.*
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for database.
 *
 */


@Module
class DatabaseModule {

    @Provides
    fun providesAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "my-app-db").build()
}
