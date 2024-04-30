package com.example.bottomsheet;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).hide();

        setContentView(R.layout.activity_main);

        MaterialButton showBottomSheetBtn = findViewById(R.id.buttonSheet);
        showBottomSheetBtn.setOnClickListener(view -> {
            MyBottomSheetDialogFragment mbsdf = new MyBottomSheetDialogFragment();
            mbsdf.show(getSupportFragmentManager(), mbsdf.getTag());
        });
    }
}
