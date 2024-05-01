package com.example.fragmentcommunication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private TextView textView;
    private EditText editText;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        textView = view.findViewById(R.id.textView1);
        editText = view.findViewById(R.id.editText1);
        button = view.findViewById(R.id.button1);
        try {
            Bundle bundle = getArguments();
            String text = bundle.get("text").toString();
            textView.setText(text);
        } catch (NullPointerException ignore) {}

        button.setOnClickListener(v -> {
            ((MainActivity)getActivity())
                    .loadFragment(new Fragment2(), editText.getText().toString());
        });

        return view;
    }
}
