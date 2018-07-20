package app.demo.example.com.footballapp.repository.remote

import android.content.SharedPreferences
import app.demo.example.com.footballapp.data.AppDatabase
import app.demo.example.com.footballapp.repository.Api
import app.demo.example.com.footballapp.repository.IRepository
import app.demo.example.com.footballapp.rx.Schedulers

/**
 * Created by Jorge Para on 10/31/17.
 * 2017 © Cognizant Technology Solutions
 */
class Repository(private val api : Api,
                 private val localStorage : AppDatabase,
                 private val schedulers : Schedulers,
                 private val preferences : SharedPreferences
) : IRepository {


}