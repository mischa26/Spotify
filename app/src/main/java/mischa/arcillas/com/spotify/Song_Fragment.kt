package mischa.arcillas.com.spotify

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class SongFragment : Fragment(){

        private var songs: List<String>? = null
        private var albums: List<String>? = null
        private val PARTS_SONG = "parts_list"
        private val PARTS_ALBUM = "parts_number"
        private var artistName: TextView? = null
        private var songName: TextView? = null
        private var TAG:String?="SONGFRAGMENT";

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            Log.d(TAG,"FRAGMENT IS CREATED!")
            if (savedInstanceState != null) {
                songs = savedInstanceState.getStringArrayList(PARTS_SONG)
                albums = savedInstanceState.getStringArrayList(PARTS_ALBUM)

            }

            val rootView = inflater?.inflate(R.layout.fragment_song, container, false)
            if (rootView != null) {
                artistName = rootView.findViewById(R.id.txtfragment_album)
                songName = rootView.findViewById(R.id.txtfragment_song)
            }
            return rootView
        }

        open fun change(songNames: String, artistNames: String) {
            artistName?.text = artistNames
            songName?.text = songNames
        }

        companion object {

            fun newInstance(mySong: Song): SongFragment {
                val args = Bundle()
                args.putSerializable("mySong", mySong)
                val fragment = SongFragment()
                fragment.arguments= args
                return fragment
    }
}
}







