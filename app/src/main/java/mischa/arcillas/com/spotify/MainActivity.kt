package mischa.arcillas.com.spotify

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), SongClickListener {

    var songFragment: SongFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val users = ArrayList<Song>()

        users.add(Song("Titibo-Tibo", "Moria Dela Torre", " • Himig Handog 2017"))
        users.add(Song("Havana", "Camilla Cabello", " • Havana"))
        users.add(Song("Arms Open", "The Script", " • Human Clay"))
        users.add(Song("How Long", "Charlie Puth", " • Alien Boy"))
        users.add(Song("Where My Love Goes", "Lawson", " • Perspective"))
        users.add(Song("Hero", "The Script", " • 3"))
        users.add(Song("Back To You", "Louis Tomlinson", " • Louis Tomlinson"))
        users.add(Song("Tell Me You Love Me", "Demi Lovato", " • Tell Me You Love Me"))
        users.add(Song("Say It First", "Sam Smith", " • The Thrill of It All"))
        users.add(Song("Happier", "Ed Sheeran", " • Divide"))
        users.add(Song("Whiskey", "Maroon 5 ft. SZA", " • Red Pill Blues"))


        var adapter = SongAdapter(users,this)
        rv.adapter = adapter

        songFragment = SongFragment.newInstance(users.get(0))

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mSongLayout, songFragment,"MySongFragment").commit();

    }

    override fun onSongClick(song: Song) {
    songFragment?.change(song.spotifyTitle, song.spotifySinger)
    }
}
