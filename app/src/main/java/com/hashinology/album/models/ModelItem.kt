package com.hashinology.album.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("MovieTable")
data class ModelItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
): Serializable{
    @PrimaryKey(autoGenerate = true)
    var idAuto: Int = 0
}