package com.mm.mgr;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mm.mgr.databinding.ActivityMainBinding;

//public class MainActivity extends AppCompatActivity {
//
//    Button btnLogOut;
//    FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btnLogOut = findViewById(R.id.btnLogout);
//        mAuth = FirebaseAuth.getInstance();
//
//        btnLogOut.setOnClickListener(view -> {
//            mAuth.signOut();
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        });
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if (user == null) {
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        }
//    }
//}

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new PlantListFragment());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.plant_list:
                    replaceFragment(new PlantListFragment());
                    break;

                case R.id.plant_recognizer:
                    replaceFragment(new RecognizerFragment());
                    break;

                case R.id.plant_notifications:
                    replaceFragment(new NotificationFragment());
                    break;


            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}