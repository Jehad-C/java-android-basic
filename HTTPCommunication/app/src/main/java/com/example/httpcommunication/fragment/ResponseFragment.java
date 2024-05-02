package com.example.httpcommunication.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.httpcommunication.MainActivity;
import com.example.httpcommunication.R;
import com.example.httpcommunication.controller.NetworkService;

public class ResponseFragment extends Fragment implements NetworkService {
    private final Activity activity;
    private View view;

    public ResponseFragment(Activity activity) {
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_response, container, false);
        return view;
    }

    @Override
    public void onResponseReceived(String response) {
        TextView textView = view.findViewById(R.id.textView2);
        activity.runOnUiThread(() -> textView.setText(response));
    }
}
