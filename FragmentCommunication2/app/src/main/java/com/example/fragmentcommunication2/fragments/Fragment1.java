package com.example.fragmentcommunication2.fragments;

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
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentcommunication2.MainActivity;
import com.example.fragmentcommunication2.R;
import com.example.fragmentcommunication2.CommunicationViewModel;

public class Fragment1 extends Fragment {
    private CommunicationViewModel viewModel;
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CommunicationViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        textView = view.findViewById(R.id.textView1);
        editText = view.findViewById(R.id.editText1);
        button = view.findViewById(R.id.button1);
        viewModel.getFragment1Text().observe(getViewLifecycleOwner(), text -> {
            textView.setText(text);
        });

        button.setOnClickListener(v -> {
            String textToPass = editText.getText().toString().trim();
            viewModel.setFragment2Text(textToPass);
            ((MainActivity)getActivity()).loadFragment(new Fragment2());
        });

        return view;
    }
}
