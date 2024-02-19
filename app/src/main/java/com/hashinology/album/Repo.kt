package com.hashinology.album

import androidx.lifecycle.LiveData
import com.hashinology.album.api.RetrofitClient
import com.hashinology.album.data.AlbumDao
import com.hashinology.album.models.AlbumModel

class Repo(val dao: AlbumDao) {
    suspend fun insert(albumModel: AlbumModel) = dao.insert(albumModel)
    suspend fun update(albumModel: AlbumModel) = dao.update(albumModel)
    suspend fun delete(albumModel: AlbumModel) = dao.delete(albumModel)
    suspend fun isExists(titleName: String): Boolean = dao.isExisits(titleName)

    val getAlbumLive: LiveData<AlbumModel> = dao.getAlbumListRoom()

    suspend fun getAlbumApi() = RetrofitClient.getInstance().getAlbumFromApi()
}