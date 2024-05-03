package com.example.fragmentcommunication2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommunicationViewModel extends ViewModel {
    private MutableLiveData<String> fragment1Data = new MutableLiveData<>();
    private MutableLiveData<String> fragment2Data = new MutableLiveData<>();

    public void setFragment1Text(String text) {
        fragment1Data.setValue(text);
    }

    public void setFragment2Text(String text) {
        fragment2Data.setValue(text);
    }

    public LiveData<String> getFragment1Text() {
        return fragment1Data;
    }

    public LiveData<String> getFragment2Text() {
        return fragment2Data;
    }
}
