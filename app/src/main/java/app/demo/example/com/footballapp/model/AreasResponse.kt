package app.demo.example.com.footballapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Guillermo Bonafonte Criado
 *
 */
@Parcelize
data class AreasResponse(
        var count: Int? = 0,
        var areas: MutableList<Area> = mutableListOf()
) : Parcelable