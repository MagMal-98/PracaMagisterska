package com.mm.mgr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PlantListFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    public PlantListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_plant_list, container, false);

        recyclerView = view.findViewById(R.id.plantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<PlantItem> options =
                new FirebaseRecyclerOptions.Builder<PlantItem>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Plants"), PlantItem.class)
                        .build();

        adapter = new RecyclerViewAdapter(options);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_plant_list, container, false);
//        //return inflater.inflate(R.layout.fragment_plant_list, container, false);
//
//        recyclerView.findViewById(R.id.plantList);
//        database = FirebaseDatabase.getInstance().getReference();
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
//
//        list = new ArrayList<>();
//        adapter = new RecyclerViewAdapter(list);
//        recyclerView.setAdapter(adapter);
//
//        database.addValueEventListener(new ValueEventListener() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    PlantItem plantItem = dataSnapshot.getValue(PlantItem.class);
//                    list.add(plantItem);
//                }
//                adapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//        return view;
//
//    }
}