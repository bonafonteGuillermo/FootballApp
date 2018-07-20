package app.demo.example.com.footballapp.model

import android.arch.persistence.room.*
import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
@Parcelize
@Entity(tableName = "user")
data class User (

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "first_name")
    var firstName: String? = null,

    @ColumnInfo(name = "last_name")
    var lastName: String? = null,

    @Ignore
    internal var picture: Bitmap? = null
) : Parcelable