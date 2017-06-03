package com.abbisqq.aquaworld;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.abbisqq.aquaworld.fragments.FishCategoryListFragment;
import com.abbisqq.aquaworld.fragments.StartingFragment;

public class MainActivity extends AppCompatActivity {


    public static boolean TABLET = false;


    //method to check if it's a phone or a tablet
    public boolean isTablet(Context context)
    {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)==4);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)== Configuration.SCREENLAYOUT_SIZE_LARGE);
        return(xlarge||large);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TABLET=isTablet(this);


        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new StartingFragment()).commit();
        }

    }

    public void startClicked(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new FishCategoryListFragment()).commit();
    }


}
