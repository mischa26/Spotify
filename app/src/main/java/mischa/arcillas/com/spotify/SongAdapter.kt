package mischa.arcillas.com.spotify

/**
 * Created by Mischa on 18/12/2017.
 */

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView

class SongAdapter (val songList: ArrayList<Song>, val listener: SongClickListener) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.song?.text = songList[position].spotifyTitle
        holder?.singer?.text = songList[position].spotifySinger
        holder?.album?.text = songList[position].spotifyAlbum
        holder?.linearLayout?.setOnClickListener {

            holder.song.setTextColor(Color.parseColor("#1DB853"))

            listener.onSongClick(songList[position])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.song_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val fragmentSong = itemView.findViewById<TextView>(R.id.txtfragment_song)
        val fragmentSinger = itemView.findViewById<TextView>(R.id.txtfragment_album)
        val song = itemView.findViewById<TextView>(R.id.txtSong)
        val singer = itemView.findViewById<TextView>(R.id.txtSinger)
        val album = itemView.findViewById<TextView>(R.id.txtAlbum)
        val linearLayout = itemView.findViewById<RelativeLayout>(R.id.linear1)


    }
}