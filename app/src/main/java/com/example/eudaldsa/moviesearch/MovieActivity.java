package com.example.eudaldsa.moviesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MovieActivity extends AppCompatActivity {

    //Model
    private Movie movie;

    //Referències al View
    private TextView titleview;
    private TextView yearview;
    private TextView ratedview;
    private TextView runtimeview;
    private TextView genreview;
    private TextView plotview;
    private TextView directorview;
    private TextView writerview;
    private TextView actorsview;
    private ImageView posterview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        try {
            InputStream stream = getAssets().open("lord.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            movie = gson.fromJson(reader, Movie.class);
        }
        catch (IOException e) {
            Toast.makeText(this, "No he pogut llegir el fitxer", Toast.LENGTH_SHORT).show();
        }

        titleview = findViewById(R.id.titleview);
        yearview = findViewById(R.id.yearview);
        ratedview = findViewById(R.id.ratedview);
        runtimeview = findViewById(R.id.runtimeview);
        genreview = findViewById(R.id.genreview);
        plotview = findViewById(R.id.plotview);
        directorview = findViewById(R.id.directorview);
        writerview = findViewById(R.id.writerview);
        actorsview = findViewById(R.id.actorsview);

        titleview.setText(movie.getTitle());
        yearview.setText(movie.getYear());
        ratedview.setText(movie.getRated());
        runtimeview.setText(movie.getRuntime());
        genreview.setText(movie.getGenre());
        plotview.setText(movie.getPlot());
        directorview.setText(movie.getDirector());
        writerview.setText(movie.getWriter());
        actorsview.setText(movie.getActors().replace(", ", "\n"));

        posterview = findViewById(R.id.posterview);
        Glide.with(this).load("file:///android_asset/poster.png").into(posterview);
    }
}
