package com.hashinology.album.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hashinology.album.models.AlbumModel

interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(albumModel: AlbumModel)

    @Update()
    suspend fun update(albumModel: AlbumModel)

    @Delete
    suspend fun delete(albumModel: AlbumModel)

    @Query("Select * From MovieTable")
    fun getAlbumList(): LiveData<AlbumModel>
}