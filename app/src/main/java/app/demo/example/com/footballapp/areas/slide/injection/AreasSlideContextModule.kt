package app.demo.example.com.footballapp.areas.slide.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Created by Guillermo Bonafonte Criado on 21-Aug-18.
 * 2018 © Cognizant Technology Solutions
 */

@Module
class AreasSlideContextModule(var context: AppCompatActivity) {

    var launchSlideContext: AppCompatActivity = context

    @AreasSlideScope
    @Provides
    fun providesLaunchSlideContextModule(): AppCompatActivity {
        return launchSlideContext
    }
}