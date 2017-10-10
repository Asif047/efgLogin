package com.example.asif047.efglogin.ShowDistrict;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asif047.efglogin.R;

import java.util.List;

/**
 * Created by encrypt on 10/10/17.
 */

public class RecyclerAdapterShowDistrict extends RecyclerView.Adapter<RecyclerAdapterShowDistrict.ShowDistrictMyViewHolder>{

    private List<ShowDistrict>showDistricts;

    public RecyclerAdapterShowDistrict(List<ShowDistrict>showDistricts)
    {
        this.showDistricts=showDistricts;
    }

    @Override
    public ShowDistrictMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_show_district,parent,false);

        return new ShowDistrictMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowDistrictMyViewHolder holder, int position) {

        holder.districtNameTV.setText(showDistricts.get(position).getDistrictName());

    }

    @Override
    public int getItemCount() {
        return showDistricts.size();
    }





    public class ShowDistrictMyViewHolder extends RecyclerView.ViewHolder
    {

        TextView districtNameTV;


        public ShowDistrictMyViewHolder(View itemView) {
            super(itemView);


            districtNameTV=(TextView)itemView.findViewById(R.id.district_name_textview);

        }
    }









}
