package app.demo.example.com.footballapp.app.injection

import android.content.Context
import app.demo.example.com.footballapp.rx.AppSchedulers
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

/**
 *
 * Dagger module for networking. It provides HTTP client and other required objects.
 *
 * Created by Guillermo Bonafonte Criado
 */
@Module
class NetworkingModule {

    @AppScope
    @Provides
    internal fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder()
                .addInterceptor(logger)
                .cache(cache)
                .build()
    }

    @AppScope
    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    internal fun provideCache(file: File): Cache {
        return Cache(file, (10 * 10 * 1000).toLong())
    }

    @AppScope
    @Provides
    internal fun provideCacheFile(context: Context): File {
        return context.filesDir
    }

    @AppScope
    @Provides
    internal fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(AppSchedulers().INTERNET_SCHEDULERS)
    }


    @Provides
    internal fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}