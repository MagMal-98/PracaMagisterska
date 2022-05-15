package com.mm.mgr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;


public class PlantInfoFragment extends Fragment {


    String title, subtitle, bloomTime, info, soilPh, sunExpoisure, purl;

    public PlantInfoFragment() {

    }

    public PlantInfoFragment(String title, String subtitle, String bloomTime, String info, String soilPh, String sunExpoisure, String purl) {
        this.title = title;
        this.subtitle = subtitle;
        this.bloomTime = bloomTime;
        this.info = info;
        this.soilPh = soilPh;
        this.sunExpoisure = sunExpoisure;
        this.purl = purl;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plant_info, container, false);

        ImageView imageHandler = view.findViewById(R.id.imagegholder);
        TextView titleHandler = view.findViewById(R.id.titleHolder);
        TextView subtitleHandler = view.findViewById(R.id.subtitleHolder);
        TextView bloomTimeHandler = view.findViewById(R.id.bloomHolder);
        TextView soilPhHandler = view.findViewById(R.id.soilHolder);
        TextView sunExpoisureHandler = view.findViewById(R.id.sunHolder);
        TextView infoHandler = view.findViewById(R.id.infoHolder);

        titleHandler.setText(title);
        subtitleHandler.setText(subtitle);
        bloomTimeHandler.setText(bloomTime);
        soilPhHandler.setText(soilPh);
        sunExpoisureHandler.setText(sunExpoisure);
        infoHandler.setText(info);
        Glide.with(getContext()).load(purl).into(imageHandler);


        return view;
    }

    public void onBackPressed() {
        AppCompatActivity activity = (AppCompatActivity) getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new PlantListFragment()).addToBackStack(null).commit();

    }
}
