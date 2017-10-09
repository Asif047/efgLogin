package com.example.asif047.efglogin.Hotel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asif047.efglogin.R;

import java.util.List;

/**
 * Created by admin on 10/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private List<Hotel> hotels;

    private final Context context;

    public RecyclerAdapter(Context ctx,List<Hotel> hotels)
    {
        this.context = ctx;
        this.hotels=hotels;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.place_name.setText(hotels.get(position).getPlaceName());
        holder.phone.setText(hotels.get(position).getPhone());
        holder.address.setText(hotels.get(position).getAddress());
        holder.datails.setText(hotels.get(position).getDetails());


        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/"+hotels.get(position).getImage().toString()).into(holder.smallIV);

        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/"+hotels.get(position).getImage().toString()).into(holder.largeIV);

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView place_name,phone,address,datails;
        ImageView smallIV,largeIV;

        public MyViewHolder(View itemView) {
            super(itemView);

            place_name=(TextView)itemView.findViewById(R.id.place_name_textview);
            phone=(TextView)itemView.findViewById(R.id.phone_textview);
            address=(TextView)itemView.findViewById(R.id.address_textview);
            datails=(TextView)itemView.findViewById(R.id.details_textview);

            smallIV=(ImageView)itemView.findViewById(R.id.small_image_textview);
            largeIV=(ImageView)itemView.findViewById(R.id.large_image_imageview);

        }
    }




}
