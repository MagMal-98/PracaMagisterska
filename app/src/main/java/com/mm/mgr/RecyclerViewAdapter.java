package com.mm.mgr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PlantInfoFragment(plantItem.getTitle(), plantItem.getSubtitle(),
                        plantItem.getBloomTime(), plantItem.getInfo(), plantItem.getSoilPh(), plantItem.getSunExposure(),  plantItem.getPurl())).addToBackStack(null).commit();
            }
        });

    }


//    protected void onCreate(Bundle savedInstanceState) {
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        replaceFragment(new PlantListFragment());
//
//        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//
//            switch(item.getItemId()){
//                case R.id.plant_list:
//                    replaceFragment(new PlantListFragment());
//                    break;
//
//                case R.id.plant_recognizer:
//                    replaceFragment(new RecognizerFragment());
//                    break;
//
//                case R.id.plant_notifications:
//                    replaceFragment(new NotificationFragment());
//                    break;
//
//                case R.id.settings:
//                    replaceFragment(new SettingsFragment());
//                    break;
//
//            }
//
//
//            return true;
//        });
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        return new MyViewHolder(view);
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = fragment.getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
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
