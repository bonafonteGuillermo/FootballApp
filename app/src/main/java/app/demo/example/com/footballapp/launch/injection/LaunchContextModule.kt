package app.demo.example.com.footballapp.launch.injection

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
class LaunchContextModule(context: AppCompatActivity) {

    var splashContext: AppCompatActivity = context

    @LaunchScope
    @Provides
    fun provideSplashContext(): AppCompatActivity {
        return splashContext
    }

}
