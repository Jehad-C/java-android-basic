package com.example.bottomnavigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.example.bottomnavigation.fragment.HomeFragment;
import com.example.bottomnavigation.fragment.ProfileFragment;
import com.example.bottomnavigation.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(i -> {
            if (i.getItemId() == R.id.nav_home) {
                loadFragment(new HomeFragment());
            } else if (i.getItemId() == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
            } else if (i.getItemId() == R.id.nav_settings) {
                loadFragment(new SettingsFragment());
            }
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
