package com.hashinology.album.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hashinology.album.Repo
import com.hashinology.album.data.AlbumDB
import com.hashinology.album.models.AlbumModel

class AlbumVM(context: Application): AndroidViewModel(context) {
    lateinit var repo: Repo
    lateinit var getAlbumInfo: LiveData<AlbumModel>


    private var _getRetro = MutableLiveData<AlbumModel>()
    var getAlbum: LiveData<AlbumModel> = _getRetro

    // init for Room
    init {
        val dao = AlbumDB.getinstance(context).getDBDao()
        repo = Repo(dao)
        getAlbum = repo.getAlbumLive
    }

    suspend fun setuuRetro(){
        val response = repo.getAlbumApi()
        try {
            if (response.isSuccessful){
                _getRetro.postValue(response.body())
            }
        }catch (e: Exception){

        }
    }
    suspend fun insert(albumModel: AlbumModel) = repo.insert(albumModel)
    suspend fun delete(albumModel: AlbumModel) = repo.delete(albumModel)
}