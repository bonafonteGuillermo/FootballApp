package app.demo.example.com.footballapp.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import app.demo.example.com.footballapp.model.Area

/**
 *
 * Created by Guillermo Bonafonte Criado on 24-Jul-18.
 * 2018 © Cognizant Technology Solutions
 */
@Dao
interface AreasDao {

    @Query("SELECT * FROM area")
    fun getAreas(): Area


}