package app.demo.example.com.footballapp.app.injection

import app.demo.example.com.footballapp.repository.Api
import app.demo.example.com.footballapp.utils.Configuration
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * Dagger module for API
 *
 */
@Module
class ApiModule {

    @AppScope
    @Provides
    fun provideApi(client: OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): Api {
        return Retrofit.Builder().client(client)
                .baseUrl(Configuration().BaseUrl)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build()
                .create(Api::class.java)
    }

}