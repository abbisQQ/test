package com.abbisqq.aquaworld.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abbisqq.aquaworld.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartingFragment extends Fragment {


    public StartingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_starting, container, false);


        // Inflate the layout for this fragment
        return view;
    }

}
