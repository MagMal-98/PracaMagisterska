package com.mm.mgr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.bumptech.glide.Glide;

public class RecyclerViewAdapter extends FirebaseRecyclerAdapter<PlantItem, RecyclerViewAdapter.MyViewHolder> {

    public RecyclerViewAdapter(@NonNull FirebaseRecyclerOptions<PlantItem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final PlantItem plantItem) {
        holder.title.setText(plantItem.getTitle());
        holder.subtitle.setText(plantItem.getSubtitle());
        Glide.with(holder.image.getContext()).load(plantItem.getPurl()).into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PlantInfoFragment(plantItem.getTitle(), plantItem.getSubtitle(), plantItem.getPurl(),
                        plantItem.getBloomTime(), plantItem.getSoilPh(), plantItem.getSunExpoisure(), plantItem.getInfo())).addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, subtitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.itemImage);
            title = itemView.findViewById(R.id.itemTitle);
            subtitle = itemView.findViewById(R.id.itemSubtitle);
        }
    }
}
