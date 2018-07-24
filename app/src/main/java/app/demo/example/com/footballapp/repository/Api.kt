package app.demo.example.com.footballapp.repository

import android.support.annotation.Keep
import app.demo.example.com.footballapp.model.AreasResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

/**
 *
 * API for authentication into the app
 *
 */
@Keep
interface Api {


    @GET("/v2/areas")
    fun getAreas(@Header("X-Auth-Token") apiToken : String) : Single<AreasResponse>



}