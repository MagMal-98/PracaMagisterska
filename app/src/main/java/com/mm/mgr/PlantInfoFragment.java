package com.mm.mgr;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class PlantInfoFragment extends Fragment {


    String title, subtitle, bloomTime, info, soilPh, sunExposure, purl;

    public PlantInfoFragment() {

    }

    public PlantInfoFragment(String title, String subtitle, String bloomTime, String info, String soilPh, String sunExposure, String purl) {
        this.title = title;
        this.subtitle = subtitle;
        this.bloomTime = bloomTime;
        this.info = info;
        this.soilPh = soilPh;
        this.sunExposure = sunExposure;
        this.purl = purl;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plant_info, container, false);

        ImageView imageHandler = view.findViewById(R.id.imageHolder);
        TextView titleHandler = view.findViewById(R.id.titleHolder);
        TextView subtitleHandler = view.findViewById(R.id.subtitleHolder);
        TextView bloomTimeHandler = view.findViewById(R.id.bloomHolder);
        TextView soilPhHandler = view.findViewById(R.id.soilHolder);
        TextView sunExposureHandler = view.findViewById(R.id.sunHolder);
        TextView infoHandler = view.findViewById(R.id.infoHolder);

        titleHandler.setText(title);
        subtitleHandler.setText(subtitle);
        bloomTimeHandler.setText("Bloom Time: " + bloomTime);
        soilPhHandler.setText("Soil PH: " + soilPh);
        sunExposureHandler.setText("Sun Exposure: " + sunExposure);
        infoHandler.setText("Useful Information: " + info);
        Glide.with(view.getContext()).load(purl).into(imageHandler);


        return view;
    }




//    @Override
//    protected void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position, @NonNull final PlantItem plantItem) {
//        holder.title.setText(plantItem.getTitle());
//        holder.subtitle.setText(plantItem.getSubtitle());
//        Glide.with(holder.image.getContext()).load(plantItem.getPurl()).into(holder.image);
//
//        holder.image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PlantInfoFragment(plantItem.getTitle(), plantItem.getSubtitle(), plantItem.getPurl(),
//                        plantItem.getBloomTime(), plantItem.getSoilPh(), plantItem.getSunExposure(), plantItem.getInfo())).addToBackStack(null).commit();
//            }
//        });
//
//    }

    public void onBackPressed() {
        AppCompatActivity activity = (AppCompatActivity) getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PlantListFragment()).addToBackStack(null).commit();

    }
}
