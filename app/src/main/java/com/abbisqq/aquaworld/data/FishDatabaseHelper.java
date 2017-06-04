package com.abbisqq.aquaworld.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by chart on 3/6/2017.
 */

public class FishDatabaseHelper  extends SQLiteAssetHelper {


    String tableName;

    public FishDatabaseHelper(Context context,String name) {
        super(context, FishContract.DATABASE_NAME, null, FishContract.DATABASE_VERSION);
        tableName =  name;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

    public Cursor getFishes() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {FishContract.SCINAME,
                FishContract.COMMONNAME,
                FishContract.AGE,
                FishContract.SIZE,
                FishContract.OVERVIEW,
                FishContract.IMAGE};

        String sqlTables = tableName;

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

        }







}
