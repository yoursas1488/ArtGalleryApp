package com.example.artgalery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ArtDetailActivity extends AppCompatActivity {

    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_detail);

        ImageView img = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView genre = findViewById(R.id.genre);
        TextView year = findViewById(R.id.year);
        TextView desc = findViewById(R.id.desc);

        btn = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        genre.setText(intent.getStringExtra("genre"));
        year.setText(intent.getStringExtra("year"));
        desc.setText(intent.getStringExtra("description"));
        Picasso.get().load(intent.getStringExtra("img")).into(img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Is Saved");
            }
        });

    }
}
