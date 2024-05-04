package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.dashboard.activities.Product1Activity;
import com.example.dashboard.activities.Product2Activity;
import com.example.dashboard.activities.Product3Activity;
import com.example.dashboard.activities.Product4Activity;
import com.example.dashboard.activities.Product5Activity;
import com.example.dashboard.activities.Product6Activity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView1 = findViewById(R.id.card1);
        CardView cardView2 = findViewById(R.id.card2);
        CardView cardView3 = findViewById(R.id.card3);
        CardView cardView4 = findViewById(R.id.card4);
        CardView cardView5 = findViewById(R.id.card5);
        CardView cardView6 = findViewById(R.id.card6);

        cardView1.setOnClickListener(v -> {
            loadActivity(new Product1Activity());
        });

        cardView2.setOnClickListener(v -> {
            loadActivity(new Product2Activity());
        });

        cardView3.setOnClickListener(v -> {
            loadActivity(new Product3Activity());
        });

        cardView4.setOnClickListener(v -> {
            loadActivity(new Product4Activity());
        });

        cardView5.setOnClickListener(v -> {
            loadActivity(new Product5Activity());
        });

        cardView6.setOnClickListener(v -> {
            loadActivity(new Product6Activity());
        });
    }

    private void loadActivity(AppCompatActivity activity) {
        Intent intent = new Intent(MainActivity.this, activity.getClass());
        startActivity(intent);
    }
}
