package com.mm.mgr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    RecyclerViewAdapterWater adapter;

    int recyclerColumns = 2; //How many columns of plants do we want displayed?

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        loadPlants();
        setRecycler(recyclerColumns, view);

        Toolbar myToolbar = view.findViewById(R.id.myToolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        assert activity != null;
        activity.setSupportActionBar(myToolbar);
        myToolbar.setBackgroundColor(Color.parseColor("#FFFFFF"));
        myToolbar.showOverflowMenu();
        activity.getSupportActionBar().setTitle("Planted ");

        myToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.addPlant:
                    Intent intentCreatePlant = new Intent(requireContext(), CreatePlantActivity.class);
                    startActivity(intentCreatePlant);
                    activity.overridePendingTransition(R.anim.anim_right_to_left, R.anim.anim_stay_put);
                    break;
            }
            return true;
        });

        return view;
    }

    //Sets up our recyclerview
    private void setRecycler(int recyclerColumns, View view){
        RecyclerView recyclerView = view.findViewById(R.id.rvPlants);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), recyclerColumns));

        if (PlantDataHolder.plantList == null) {
            //Should show an empty state. NEED TO DO!
        } else {
            adapter = new RecyclerViewAdapterWater(getContext(), PlantDataHolder.plantList);
            //adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }
    }

    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.main_app_bar, menu);
        return true;
    }


    //Load SharedPreferences
    private void loadPlants() {
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.clear();
//        editor.commit();
        String json  = sharedPref.getString("plant list", null);
        Type type = new TypeToken<ArrayList<Plant>>() {}.getType();
        PlantDataHolder.plantList = gson.fromJson(json, type);
        if (PlantDataHolder.plantList == null){
            PlantDataHolder.plantList = new ArrayList<>();
        }
    }


}