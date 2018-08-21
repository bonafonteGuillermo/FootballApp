package app.demo.example.com.footballapp.launch.slide.injection

import android.support.v7.app.AppCompatActivity
import app.demo.example.com.footballapp.launch.injection.LaunchScope
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

@Module
class LaunchSlideContextModule(var context: AppCompatActivity) {

    var launchSlideContext: AppCompatActivity = context

    @LaunchSlideScope
    @Provides
    fun providesLaunchSlideContextModule(): AppCompatActivity {
        return launchSlideContext
    }
}