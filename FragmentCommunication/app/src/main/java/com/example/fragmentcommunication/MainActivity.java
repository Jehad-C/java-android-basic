package com.example.fragmentcommunication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Fragment1(), "");
    }

    public void loadFragment(Fragment fragment, String textToPass) {
        if (!textToPass.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString("text", textToPass);
            fragment.setArguments(bundle);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout1, fragment);
        transaction.addToBackStack(null).setReorderingAllowed(true);
        transaction.commit();
    }
}
