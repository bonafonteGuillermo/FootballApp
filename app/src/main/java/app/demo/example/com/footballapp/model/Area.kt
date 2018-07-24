package app.demo.example.com.footballapp.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Guillermo Bonafonte Criado on 24-Jul-18.
 * 2018 © Cognizant Technology Solutions
 */
@Entity(tableName = "area")
@Parcelize
data class Area(
        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = false)
        var id: Int? = 0,

        @ColumnInfo(name = "name")
        var name: String? = "",

        @ColumnInfo(name = "country_code")
        var countryCode: String? = "",

        @ColumnInfo(name = "parent_area_id")
        var parentAreaId: Int? = 0,

        @ColumnInfo(name = "parent_area")
        var parentArea: String? = ""
) : Parcelable