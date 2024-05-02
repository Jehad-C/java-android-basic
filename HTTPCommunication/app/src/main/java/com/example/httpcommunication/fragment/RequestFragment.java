package com.example.httpcommunication.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.net.MalformedURLException;
import java.net.URL;

import com.example.httpcommunication.MainActivity;
import com.example.httpcommunication.R;
import com.example.httpcommunication.controller.NetworkController;

public class RequestFragment extends Fragment {
    private final Activity activity;

    public RequestFragment(Activity activity) {
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
                NetworkController controller = new NetworkController(activity, url);
                ResponseFragment responseFragment = new ResponseFragment(activity);
                controller.execute(responseFragment);
                ((MainActivity)getActivity()).loadFragment(responseFragment);
            } catch (MalformedURLException ignore) {}
        });

        return view;
    }
}
