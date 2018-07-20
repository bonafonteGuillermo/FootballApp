package app.demo.example.com.footballapp.app.injection

import android.content.Context
import android.content.SharedPreferences
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides

/**
 * Created by Guillermo Bonafonte on 14/11/17.
 * 2017 © Cognizant Technology Solutions
 */

@Module
class SharedPreferencesModule {

    @AppScope
    @Provides
    fun providesSharedPreferences(context: Context): SharedPreferences =
            SecurePreferences(context, "mypreferences", "user_prefs.xml")


}