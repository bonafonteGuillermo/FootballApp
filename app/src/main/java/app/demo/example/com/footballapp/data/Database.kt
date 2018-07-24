package app.demo.example.com.footballapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.demo.example.com.footballapp.model.Area


@Database(entities = arrayOf(Area::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun areasDao(): AreasDao

}
