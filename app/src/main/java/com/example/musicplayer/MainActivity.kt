package com.example.musicplayer

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val songs = mutableListOf<Song>()
    private var currentSong: Song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songNameTextView = findViewById<TextView>(R.id.songNameTextView)
        val songArtistEditText = findViewById<TextView>(R.id.songArtistTextView)
        val songYearEditText = findViewById<TextView>(R.id.songYearTextView)
        val songDurationEditText = findViewById<TextView>(R.id.songDurationTextView)
        val submitSongButton = findViewById<TextView>(R.id.submitSongButton)
        val songsTextView = findViewById<TextView>(R.id.songsTextView)
        val outputTextView = findViewById<TextView>(R.id.outputTextView)
        val playButton = findViewById<Button>(R.id.playButton)
        val pauseButton = findViewById<Button>(R.id.pauseButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        val favouriteButton = findViewById<Button>(R.id.favouriteButton)

        submitSongButton.setOnClickListener {
            val name = songNameTextView.text.toString()
            val artist = songArtistEditText.text.toString()
            val year = songYearEditText.text.toString().toIntOrNull() ?: 0
            val duration = songDurationEditText.text.toString()

            val song = Song(name, artist, year, duration)
            songs.add(song)
            currentSong = song

            var songDisplay = ""
            for (s in songs) {
                songDisplay += "${s.GetDisplayString()}\n\n"

                songsTextView.text = songDisplay

                playButton.setOnClickListener {
                    currentSong?.Play(outputTextView)

                    pauseButton.setOnClickListener {
                        currentSong?.Puase(outputTextView)

                        stopButton.setOnClickListener {
                            currentSong?.Stop(outputTextView)

                            favouriteButton.setOnClickListener {
                                currentSong?.Favourite(outputTextView)
                            }
                        }
                    }
                }
            }
        }
    }
}