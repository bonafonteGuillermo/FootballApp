package app.demo.example.com.footballapp.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
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
    fun getAreas(): List<Area>

    @Query("SELECT parent_area FROM area GROUP BY parent_area")
    fun getGroupedAreas(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArea(area: Area)

}