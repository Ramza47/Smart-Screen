import android.util.Log
import android.widget.TextView

class Song (
    songName: String,
    songArtist: String,
    songYear: Int,
    songDuration: String) {

    //  properties
    var name: String = ""
    var artist: String = ""
    var year: Int = 0
    var duration: String = ""

    // init block is used to set the values from
    // the primary constructor into the properties
    init {
        name = songName
        artist = songArtist
        year = songYear
        duration = songDuration

        // secondary constructor with only name and artist
        constructor(songName: String, songArtist: String) :
        this(songName, songArtist, 0, "") {

            fun Play(outputTextView: TextView) {
                outputTextView.text = "$name playing now"

                fun Pause(outputTextView: TextView) {
                    outputTextView.text = "$name paused now"

                    fun Stop(outputTextView: TextView) {
                        outputTextView.text = "$name stopped now"

                        fun Favourite(outputTextView: TextView): Boolean {
                            outputTextView.text = "$name favourited now"
                            return true

                            fun GetDisplayString(): String {
                                return "$name - $artist($duration)"
                            }
                        }
                    }
                }
            }
        }
    }
}