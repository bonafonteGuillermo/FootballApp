package app.demo.example.com.footballapp.app.injection

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for application context
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class AppContextModule(context: Context) {

    private val context: Context = context

    @AppScope
    @Provides
    fun provideAppContext(): Context = context
    
}