package com.sahmyook.ugs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container , Bundle savedlnstanceState ){
        return inflater.inflate(R.layout.activity_home, container , false);
    }
}