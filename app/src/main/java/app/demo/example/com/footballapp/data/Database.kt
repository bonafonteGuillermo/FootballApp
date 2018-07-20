package app.demo.example.com.footballapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.demo.example.com.footballapp.model.User


@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

}
