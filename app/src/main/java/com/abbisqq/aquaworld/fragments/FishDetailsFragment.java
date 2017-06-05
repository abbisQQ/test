package com.abbisqq.aquaworld.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abbisqq.aquaworld.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FishDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FishDetailsFragment extends Fragment implements View.OnClickListener{
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


    private ImageButton measureButton,phButton;
    private ImageView fishImage;
    private TextView sciNameTV,commonNameTV;


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

        fishImage = (ImageView)view.findViewById(R.id.fish_main_image);

        measureButton = (ImageButton)view.findViewById(R.id.measure_button);
        measureButton.setOnClickListener(this);

        Picasso.with(getContext()).load(R.drawable.measure).fit().into(measureButton);

        Picasso.with(getContext()).load(mImage).fit().placeholder(R.drawable.progress_animation).into(fishImage);

        sciNameTV = (TextView)view.findViewById(R.id.sciName_tv);
        sciNameTV.setText(getString(R.string.scientific_name)+mSci);

        commonNameTV = (TextView)view.findViewById(R.id.common_name_tv);

        if(mCom==null||mCom.isEmpty()||mCom.equals("N/A"))
            mCom = "    N/A    ";
        commonNameTV.setText(getString(R.string.common_name) + mCom);


        phButton = (ImageButton)view.findViewById(R.id.ph_button);
        phButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.measure_button:
                Toast.makeText(getContext(),mSize,Toast.LENGTH_SHORT).show();
                break;
            case R.id.ph_button:
                Toast.makeText(getContext(),mPh,Toast.LENGTH_SHORT).show();

        }
    }
}
