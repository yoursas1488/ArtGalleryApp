package com.example.artgalery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ArtViewHolder> {
    private Context context;
    private List<Art> artList;

    public ArtAdapter(Context context, List<Art> artList) {
        this.context = context;
        this.artList = artList;
    }

    @NonNull
    @Override
    public ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_art, parent, false);
        return new ArtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtViewHolder holder, int position) {
        Art art = artList.get(position);
        Picasso.get().load(art.getImg()).into(holder.img);

        holder.itemView.setOnClickListener(v -> {

            Animation zoomInAnimation = AnimationUtils.loadAnimation(context, R.anim.zoom_in);
            holder.img.startAnimation(zoomInAnimation);

            Intent intent = new Intent(context, ArtDetailActivity.class);
            intent.putExtra("description", art.getDescription());
            intent.putExtra("genre", art.getGenre());
            intent.putExtra("img", art.getImg());
            intent.putExtra("title", art.getTitle());
            intent.putExtra("year", art.getYear());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return artList.size();
    }

    public static class ArtViewHolder extends RecyclerView.ViewHolder {
        ImageView img;


        public ArtViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
