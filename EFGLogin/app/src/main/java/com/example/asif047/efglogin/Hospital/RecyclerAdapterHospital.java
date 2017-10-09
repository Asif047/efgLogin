package com.example.asif047.efglogin.Hospital;

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

public class RecyclerAdapterHospital extends RecyclerView.Adapter<RecyclerAdapterHospital.HospitalMyViewHolder> {


    private List<Hospital> hospitals;
    private final Context context;


    public RecyclerAdapterHospital(Context ctx,List<Hospital> hospitals)
    {
        this.context = ctx;
        this.hospitals=hospitals;
    }


    @Override
    public HospitalMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_hospital,parent,false);

        return new HospitalMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HospitalMyViewHolder holder, int position) {


        holder.place_name.setText(hospitals.get(position).getPlaceName());
        holder.phone.setText(hospitals.get(position).getPhone());
        holder.address.setText(hospitals.get(position).getAddress());
        holder.datails.setText(hospitals.get(position).getDetails());



        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/"+hospitals.get(position).getImage().toString()).into(holder.smallIV);

        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/"+hospitals.get(position).getImage().toString()).into(holder.largeIV);

    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }



    public class HospitalMyViewHolder extends RecyclerView.ViewHolder
    {

        TextView place_name,phone,address,datails;
        ImageView smallIV,largeIV;


        public HospitalMyViewHolder(View itemView) {
            super(itemView);




            place_name=(TextView)itemView.findViewById(R.id.place_name_textview_hospital);
            phone=(TextView)itemView.findViewById(R.id.phone_textview_hospital);
            address=(TextView)itemView.findViewById(R.id.address_textview_hospital);
            datails=(TextView)itemView.findViewById(R.id.details_textview_hospital);

            smallIV=(ImageView)itemView.findViewById(R.id.small_image_textview_hospital);
            largeIV=(ImageView)itemView.findViewById(R.id.large_image_imageview_hospital);


        }
    }




}
