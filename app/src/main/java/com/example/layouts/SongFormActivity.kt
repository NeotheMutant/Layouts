package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.models.SongsViewModel
import kotlinx.android.synthetic.main.activity_song_form.*

class SongFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_form)

        val model = ViewModelProviders.of(this)[SongsViewModel::class.java]
        val update = intent.hasExtra(PlayListActivity.SONGNAME)
        val songID = intent.getIntExtra(PlayListActivity.SONGID, 0)
        val position = intent.getIntExtra(PlayListActivity.POSITION, 0)



        if (update) {

            etSongName.setText(intent.getStringExtra(PlayListActivity.SONGNAME))
            etUrl.setText(intent.getStringExtra(PlayListActivity.SONGURL))
            btnAddSong.text = getString(R.string.Update)
            btnDelete.visibility = View.VISIBLE

        }


        btnAddSong.setOnClickListener {

            if (update) {
                model.updateSong(songID, etSongName.text.toString(), etUrl.text.toString())
                val intent = Intent()
                intent.putExtra(PlayListActivity.POSITION, position)
                intent.putExtra(PlayListActivity.SONGNAME, etSongName.text.toString())
                intent.putExtra(PlayListActivity.SONGURL, etUrl.text.toString())
                intent.putExtra(PlayListActivity.SONGID, songID)
                setResult(UPDATE, intent)
            } else {

                model.insertSongs(etSongName.text.toString(), etUrl.text.toString())
                val intent = Intent()
                intent.putExtra(PlayListActivity.SONGNAME, etSongName.text.toString())
                intent.putExtra(PlayListActivity.SONGURL, etUrl.text.toString())
                intent.putExtra(PlayListActivity.SONGID, songID)

                setResult(INSERT,intent)
            }

            finish()
        }

        btnDelete.setOnClickListener {

            model.deleteSong(songID, etSongName.text.toString(), etUrl.text.toString())
            val intent = Intent()
            intent.putExtra(PlayListActivity.POSITION, position)
            setResult(DELETE, intent)
            finish()
        }


    }

    companion object {
        const val UPDATE = 1
        const val DELETE = 2
        const val INSERT = 3


    }


}

