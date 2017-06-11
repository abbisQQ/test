package com.abbisqq.aquaworld.fragments;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abbisqq.aquaworld.R;
import com.abbisqq.aquaworld.adapters.CategoryRecViewAdapter;
import com.abbisqq.aquaworld.data.FishContract;
import com.abbisqq.aquaworld.data.FishFamiliesData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FishCategoryListFragment extends Fragment implements CategoryRecViewAdapter.ItemClickCallBack{

    RecyclerView recyclerView;
    CategoryRecViewAdapter adapter;
    private ArrayList listData;

    public FishCategoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.category_rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listData = (ArrayList) FishFamiliesData.getListData();
        adapter =  new CategoryRecViewAdapter(listData,getActivity());
        adapter.setItemClickCallBack(this);
        recyclerView.setAdapter(adapter);



        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onItemClick(int p) {
        switch (p){
            case 0:
                getFragmentManager().beginTransaction().
                        replace(R.id.main_container,new FishListFragment(FishContract.TABLE_NAME_CICHLIDS))
                        .addToBackStack("added").commit();
                break;
            case 1:
                getFragmentManager().beginTransaction().
                        replace(R.id.main_container,new FishListFragment(FishContract.TABLE_NAME_TETRAS))
                        .addToBackStack("added").commit();
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    }





}
