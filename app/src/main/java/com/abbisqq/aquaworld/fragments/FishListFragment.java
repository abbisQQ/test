package com.abbisqq.aquaworld.fragments;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abbisqq.aquaworld.R;
import com.abbisqq.aquaworld.adapters.RecVAdapter;
import com.abbisqq.aquaworld.data.FishDatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class FishListFragment extends Fragment {

    RecyclerView recyclerView;
    RecVAdapter adapter;
    FishDatabaseHelper helper;
    Cursor cursor;
    Context context;
    String tableName;
    public FishListFragment() {
        // Required empty public constructor
    }
    public FishListFragment(String name) {
        tableName = name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish_list, container, false);


        context = getContext();
        helper = new FishDatabaseHelper(context, tableName);
        cursor = helper.getFishes();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView)view.findViewById(R.id.fish_rv);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecVAdapter(cursor,context);
        recyclerView.setAdapter(adapter);



        // Inflate the layout for this fragment
        return view;
    }

}
