package com.example.asif047.efglogin.Tourist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asif047.efglogin.Hotel.RecyclerAdapter;
import com.example.asif047.efglogin.R;

import java.util.List;

/**
 * Created by encrypt on 10/8/17.
 */

public class RecyclerAdapterTourist extends RecyclerView.Adapter<RecyclerAdapterTourist.TouristmyViewHolder> {

    private List<Tourist> tourists;

    private final Context context;

    public RecyclerAdapterTourist(Context ctx,List<Tourist> tourists)
    {
        this.context = ctx;
        this.tourists=tourists;
    }


    @Override
    public TouristmyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_tourist,parent,false);

        return new TouristmyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TouristmyViewHolder holder, int position) {


        holder.place_name.setText(tourists.get(position).getPlaceName());
        holder.phone.setText(tourists.get(position).getPhone());
        holder.address.setText(tourists.get(position).getAddress());
        holder.datails.setText(tourists.get(position).getDetails());



        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/"+tourists.get(position).getImage().toString()).into(holder.smallIV);

        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/"+tourists.get(position).getImage().toString()).into(holder.largeIV);


    }

    @Override
    public int getItemCount() {
        return tourists.size();
    }



    public class TouristmyViewHolder extends RecyclerView.ViewHolder
    {


        TextView place_name,phone,address,datails;
        ImageView smallIV,largeIV;


        public TouristmyViewHolder(View itemView) {
            super(itemView);



            place_name=(TextView)itemView.findViewById(R.id.place_name_textview_tourist);
            phone=(TextView)itemView.findViewById(R.id.phone_textview_tourist);
            address=(TextView)itemView.findViewById(R.id.address_textview_tourist);
            datails=(TextView)itemView.findViewById(R.id.details_textview_tourist);

            smallIV=(ImageView)itemView.findViewById(R.id.small_image_textview_tourist);
            largeIV=(ImageView)itemView.findViewById(R.id.large_image_imageview_tourist);

        }
    }




}
