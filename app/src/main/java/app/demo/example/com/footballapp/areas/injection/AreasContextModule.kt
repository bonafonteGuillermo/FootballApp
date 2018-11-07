package app.demo.example.com.footballapp.areas.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of Areas screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class AreasContextModule(context: AppCompatActivity) {

    var areasContext: AppCompatActivity = context

    @AreasScope
    @Provides
    fun provideAreasContext(): AppCompatActivity {
        return areasContext
    }

}
