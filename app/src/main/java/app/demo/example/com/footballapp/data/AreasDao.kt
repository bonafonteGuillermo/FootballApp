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

    @Query("SELECT id,name,country_code,parent_area_id,parent_area FROM area")
    fun getAreas(): List<Area>

    @Query("SELECT id,name,country_code,parent_area_id,parent_area " +
            "FROM area " +
            "WHERE parent_area<>'null' AND parent_area<>'World' " +
            "GROUP BY parent_area")
    fun getGroupedAreas(): List<Area>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArea(area: Area)

}