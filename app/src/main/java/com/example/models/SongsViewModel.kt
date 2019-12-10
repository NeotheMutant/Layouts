package com.example.models

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appctx
import com.example.dao.SongDao
import com.example.database.SongsDatabase
import com.example.entities.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongsViewModel : ViewModel() {

    var db: SongDao = SongsDatabase.getDatabase(appctx).songDao()

    var songListLive = MutableLiveData<List<Song>>()

    var songInfo = MutableLiveData<Song>()

    var songlist = arrayListOf<Song>()
    fun insertSongs(song: String, url: String) {

        viewModelScope.launch(Dispatchers.IO) {
            db.insertSong(Song(0,song, url))
            Log.d("Inserted", "$song   $url")
        }

        songInfo.value = Song(0,song,url)

    }

    fun getSongList(): ArrayList<Song> {

        viewModelScope.launch(Dispatchers.IO) {
            songlist.clear()
            songlist.addAll( db.getALL())
        }

        songListLive.value = songlist

        return songlist
    }

    fun updateSong(id:Int,name:String,url:String){

        viewModelScope.launch(Dispatchers.Default) {
            db.updateSong(Song(id,name,url))
        }


    }

    fun deleteSong(id:Int,name: String,url: String){

        viewModelScope.launch(Dispatchers.IO) {
            db.deleteSong(Song(id,name,url))

        }

    }

    fun deleteAll() {

        viewModelScope.launch(Dispatchers.IO) {
            db.deALL()
        }


    }


}