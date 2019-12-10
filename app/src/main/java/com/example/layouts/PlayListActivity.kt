package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapters.GenAdapter
import com.example.entities.Song
import com.example.models.SongsViewModel
import kotlinx.android.synthetic.main.activity_playlist.*
import kotlinx.android.synthetic.main.contact_view.view.*
import kotlinx.android.synthetic.main.view_friends.view.*

class PlayListActivity : AppCompatActivity() {

    lateinit var viewAdapter: GenAdapter<Song, SongListViewHolder>
    lateinit var viewAdapterFriends: RecyclerView.Adapter<*>
    lateinit var model: SongsViewModel
    lateinit var song: Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        /*ViewModel*/

        model = ViewModelProviders.of(this)[SongsViewModel::class.java]

        /*Adapter binding For PlayList*/

        val list = model.getSongList()

        viewAdapter = GenAdapter(
            list,
            { SongListViewHolder(it) },
            R.layout.contact_view
        ) { position, holder ->
            holder.itemView.tvName.text = list[position].songName

            holder.itemView.setOnClickListener {

                val intent = Intent(this, SongFormActivity::class.java).apply {
                    putExtra(SONGNAME, list[position].songName)
                    putExtra(SONGURL, list[position].url)
                    putExtra(SONGID, list[position].songId)
                    putExtra(POSITION, position)
                }
                startActivityForResult(intent, UPDATE_DELETE_REQUEST)

            }
            /* holder.itemView.setOnClickListener {
                 Toast.makeText(this, "Goes to Song Sites", Toast.LENGTH_SHORT).show()

             }*/

        }

        rvSongList.apply {
            layoutManager = LinearLayoutManager(this@PlayListActivity)
            adapter = viewAdapter
        }

        /* Adapter binding for friends*/

        val listFriends = arrayListOf("A")
        viewAdapterFriends = GenAdapter(
            listFriends,
            { FriendsViewHolder(it) },
            R.layout.view_friends
        ) { position, holder ->
            holder.itemView.tvFriendsName.text = listFriends[position]

            holder.itemView.setOnClickListener {

                Toast.makeText(this, "Goes to Song Sites", Toast.LENGTH_SHORT).show()

            }

        }
        rvFriendsList.apply {
            layoutManager =
                LinearLayoutManager(this@PlayListActivity, RecyclerView.HORIZONTAL, false)
            adapter = viewAdapterFriends
        }

        fabAddSong.setOnClickListener {
            startActivityForResult(Intent(this, SongFormActivity::class.java), INSERT_REQUEST)

        }


    }

    inner class SongListViewHolder(view: View) : RecyclerView.ViewHolder(view)
    inner class FriendsViewHolder(view: View) : RecyclerView.ViewHolder(view)

    companion object {
        const val SONGNAME = "name"
        const val SONGURL = "url"
        const val SONGID = "id"
        const val UPDATE_DELETE_REQUEST = 1
        const val INSERT_REQUEST = 2
        const val POSITION = "position"

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var position = 0

        if (requestCode == UPDATE_DELETE_REQUEST) {
            if (resultCode == SongFormActivity.UPDATE) {
                data?.let {
                    position = data.getIntExtra(POSITION, 0)
                    song = Song(
                        data.getIntExtra(SONGID, 0),
                        data.getStringExtra(SONGNAME),
                        data.getStringExtra(SONGURL)
                    )
                    Log.d("Playlist Activity", "position = $position")
                }

                viewAdapter.dataUpdate(position, song)
            }
            if (resultCode == SongFormActivity.DELETE) {

                data?.let {
                    position = data.getIntExtra(POSITION, 0)
                }
                viewAdapter.dataDelete(position)
            }


        }

        if (requestCode == INSERT_REQUEST && resultCode == SongFormActivity.INSERT) {

            data?.let {
                song = Song(
                    data.getIntExtra(SONGID, 0),
                    data.getStringExtra(SONGNAME),
                    data.getStringExtra(SONGURL)
                )


                viewAdapter.dataInsert(song)

            }


        }


    }
}


