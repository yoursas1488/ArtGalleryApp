package com.example.artgalery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FavoriteActivity extends AppCompatActivity {

     private TextView title ,title_2 ;
     private ImageView img, img_2;
     String img1,img2;
    String title1, title2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        title = findViewById(R.id.title);
        title_2 = findViewById(R.id.title_2);
        img = findViewById(R.id.img);
        img_2 = findViewById(R.id.img_2);
        getData();

//        title.setText("1111");




    }
    void getData() {

        FirebaseDatabase.getInstance().getReference().child("data").child("art_1")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    img1 = snapshot.child("img").getValue().toString();
                    title1 = snapshot.child("title").getValue().toString();
                    Picasso.get().load(img1).into(img);
                    title.setText(title1);

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
                });
        FirebaseDatabase.getInstance().getReference().child("data").child("art_4")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        img2 = snapshot.child("img").getValue().toString();
                        title2 = snapshot.child("title").getValue().toString();
                        Picasso.get().load(img2).into(img_2);
                        title_2.setText(title2);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }
}
