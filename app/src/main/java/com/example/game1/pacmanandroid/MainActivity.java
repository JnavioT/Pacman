package com.example.game1.pacmanandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static MediaPlayer player;

    // Method to start activity for Help button
    public void showHelpScreen(View view) {
        Intent helpIntent = new Intent(this, HelpActivity.class);
        startActivity(helpIntent);
    }

    // Method to start activity for Play button
    public void showPlayScreen(View view) {
        Intent playIntent = new Intent(this, PlayActivity.class);
        startActivity(playIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.pacman_song);
        player.setVolume(100, 100);
        player.setLooping(true);
        player.start();
    }

    public static MediaPlayer getPlayer() {
        return player;
    }

    @Override
    public void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    public void onResume() {
        Log.i("info", "MainActivity onResume");
        super.onResume();
        player.start();
    }

}
