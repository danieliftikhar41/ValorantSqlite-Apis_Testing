package com.example.logginvalorant.Controllers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logginvalorant.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detaills#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detaills extends Fragment {


    public Detaills() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_detaills, container, false);
        return view;

    }
}