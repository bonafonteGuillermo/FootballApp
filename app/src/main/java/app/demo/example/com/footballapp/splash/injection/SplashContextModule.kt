package app.demo.example.com.footballapp.splash.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of Splash screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class SplashContextModule(context: AppCompatActivity) {

    var splashContext: AppCompatActivity = context

    @SplashScope
    @Provides
    fun provideSplashContext(): AppCompatActivity {
        return splashContext
    }

}
