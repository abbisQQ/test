package com.abbisqq.aquaworld.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abbisqq.aquaworld.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SCINAME = "sci_name";
    private static final String ARG_COMMONNAME = "common_name";
    private static final String ARG_SIZE = "size";
    private static final String ARG_PH = "ph";
    private static final String ARG_AGGRESSION = "aggression";
    private static final String ARG_DIET = "diet";
    private static final String ARG_DIFFICULT = "difficult";
    private static final String ARG_TEMPERATURE = "temperature";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_BREEDING = "breeding";
    private static final String ARG_OVERVIEW = "overview";

    // TODO: Rename and change types of parameters
    private String mSci;
    private String mCom;
    private String mSize;
    private String mPh;
    private String mAggr;
    private String mDiet;
    private String mDifficult;
    private String mTemperature;
    private String mImage;
    private String mBreed;
    private String mOver;

    TextView test;

    public FishDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment FishDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FishDetailsFragment newInstance(String sciName, String commonName,String size,String ph,
                                                  String aggresion,String diet,String difficult, String temperature,
                                                  String image,String breeding,String overview) {
        FishDetailsFragment fragment = new FishDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SCINAME, sciName);
        args.putString(ARG_COMMONNAME, commonName);
        args.putString(ARG_SIZE, size);
        args.putString(ARG_PH, ph);
        args.putString(ARG_AGGRESSION, aggresion);
        args.putString(ARG_DIET, diet);
        args.putString(ARG_DIFFICULT, difficult);
        args.putString(ARG_TEMPERATURE, temperature);
        args.putString(ARG_IMAGE, image);
        args.putString(ARG_BREEDING, breeding);
        args.putString(ARG_OVERVIEW, overview);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSci = getArguments().getString(ARG_SCINAME);
            mCom = getArguments().getString(ARG_COMMONNAME);
            mSize = getArguments().getString(ARG_SIZE);
            mPh = getArguments().getString(ARG_PH);
            mAggr = getArguments().getString(ARG_AGGRESSION);
            mDiet = getArguments().getString(ARG_DIET);
            mDifficult = getArguments().getString(ARG_DIFFICULT);
            mTemperature = getArguments().getString(ARG_TEMPERATURE);
            mImage = getArguments().getString(ARG_IMAGE);
            mBreed = getArguments().getString(ARG_BREEDING);
            mOver = getArguments().getString(ARG_OVERVIEW);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fish_details, container, false);


        test = (TextView)view.findViewById(R.id.testtv);
        test.append(mSci+"\n"+
                mCom+"\n"+mSize+"\n"+mPh+"\n"+mAggr+"\n"+mDiet+"\n"+mTemperature);


        return view;
    }

}
