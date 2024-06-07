package com.example.lab1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MusicActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button playPauseBtn;
    Button stopBtn;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.music_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.music_player), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sample);
        playPauseBtn = findViewById(R.id.playPauseBtn);
        stopBtn = findViewById(R.id.stopBtn);
        videoView = findViewById(R.id.videoWave);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wave);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);
        });

        mediaPlayer.start();
        playPauseBtn.setText("Pause");

        playPauseBtn.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                videoView.pause();
                playPauseBtn.setText("Play");
            }
            else {
                mediaPlayer.start();
                videoView.start();
                playPauseBtn.setText("Pause");
            }
        });

        stopBtn.setOnClickListener(v -> {
            mediaPlayer.stop();
            videoView.stopPlayback();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sample);
            videoView.setVideoURI(uri);
            playPauseBtn.setText("Play");
        });
    }
}