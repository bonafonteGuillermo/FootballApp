package app.demo.example.com.footballapp.competitions.injection

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 *
 * Dagger module for context of Competitions screen
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class CompetitionsContextModule(context: AppCompatActivity) {

    var competitionsContext: AppCompatActivity = context

    @CompetitionsScope
    @Provides
    fun provideCompetitionsContext(): AppCompatActivity {
        return competitionsContext
    }

}
