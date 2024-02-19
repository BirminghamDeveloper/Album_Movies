package com.hashinology.album.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hashinology.album.models.AlbumModel

@Database(
    entities = arrayOf(AlbumModel::class),
    version = 0
)
abstract class AlbumDB: RoomDatabase() {
    abstract fun getDBDao(): AlbumDao

    companion object{
        private var instance: AlbumDB? = null

        fun getinstance(context: Context): AlbumDB{
            if(instance == null){
                synchronized(AlbumDB::class.java){
                    if (instance == null){
                        instanceSetup(context)
                    }
                }
            }
            return instance!!
        }

        private fun instanceSetup(context: Context) {
            Room.databaseBuilder(
                context,
                AlbumDB::class.java,
                "albumDB"
            )
        }
    }
}