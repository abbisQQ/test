package com.abbisqq.aquaworld.fragments;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abbisqq.aquaworld.R;
import com.abbisqq.aquaworld.adapters.RecVAdapter;
import com.abbisqq.aquaworld.data.FishContract;
import com.abbisqq.aquaworld.data.FishDatabaseHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class FishListFragment extends Fragment implements RecVAdapter.ItemClickCallBack{

    RecyclerView recyclerView;
    RecVAdapter adapter;
    FishDatabaseHelper helper;
    Cursor cursor;
    Context context;
    String tableName;
    public FishListFragment() {
        // Required empty public constructor
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!! Creating another constructor and passing it some values is dangerous!!!!!!!!!!!!!!!!!!
    //The app will crush when it rotates to solve that you must save that name in saveInstanceState as i did below.

    public FishListFragment(String name) {
        tableName = name;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish_list, container, false);

        if(savedInstanceState!=null) {
            tableName = savedInstanceState.getString("table_name");

        }
        context = getContext();
        helper = new FishDatabaseHelper(context, tableName);
        cursor = helper.getFishes();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView = (RecyclerView) view.findViewById(R.id.fish_rv);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecVAdapter(cursor, context);
        adapter.setItemClickCallBack(this);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("table_name",tableName);
    }

    @Override
    public void onItemClick(int p) {

        Fragment fragment =  FishDetailsFragment.newInstance(cursor,p);

            this.getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container,fragment)
                    .addToBackStack(null)
                    .commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        helper.close();
    }



}
