package com.abbisqq.aquaworld.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abbisqq.aquaworld.R;
import com.abbisqq.aquaworld.data.FishContract;
import com.squareup.picasso.Picasso;

/**
 * Created by chart on 3/6/2017.
 */

public class RecVAdapter extends RecyclerView.Adapter<RecVAdapter.RecVHolder>{

    private Cursor mCursor;
    private Context mContext;



    private ItemClickCallBack itemClickCallBack;

    public  interface ItemClickCallBack {
        void onItemClick(int p);
    }


    public void setItemClickCallBack(final ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }





    public RecVAdapter(Cursor mCursor, Context mContext) {
        this.mCursor = mCursor;
        this.mContext = mContext;
    }

    @Override
    public RecVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.fish_list_row,parent,false);

        return new RecVHolder(view);
    }

    @Override
    public void onBindViewHolder(RecVHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }


        holder.tv.setText(mCursor.getString(mCursor.getColumnIndex(FishContract.SCINAME)));

        Picasso.with(mContext)
                .load(mCursor.getString(mCursor.getColumnIndex(FishContract.IMAGE)))
                .error(R.drawable.nofish)
                .placeholder(R.drawable.progress_animation)
                .fit().into(holder.iv);


    }


    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    class RecVHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView iv;
        TextView tv;
        View container;


        public RecVHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.list_image_view);
            tv = (TextView)itemView.findViewById(R.id.list_name_text_view);
            container = itemView.findViewById(R.id.fish_list_container);
            container.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fish_list_container) {
            //gets the position of the item hat was clicked
            itemClickCallBack.onItemClick(getAdapterPosition());
        }
    }
    }



}
