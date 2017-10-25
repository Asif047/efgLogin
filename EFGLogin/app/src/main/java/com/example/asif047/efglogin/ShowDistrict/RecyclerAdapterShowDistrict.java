package com.example.asif047.efglogin.ShowDistrict;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asif047.efglogin.District.DistrictActivity;
import com.example.asif047.efglogin.Hotel.RecyclerAdapter;
import com.example.asif047.efglogin.ItemClickListener;
import com.example.asif047.efglogin.R;

import java.util.List;

/**
 * Created by encrypt on 10/10/17.
 */

public class RecyclerAdapterShowDistrict extends RecyclerView.Adapter<RecyclerAdapterShowDistrict.ShowDistrictMyViewHolder>{

    //new starts
    public static String id="";
    Context context;
    //new ends


    private List<ShowDistrict>showDistricts;

    public RecyclerAdapterShowDistrict(Context context,List<ShowDistrict>showDistricts)
    {
        this.context=context;
        this.showDistricts=showDistricts;
    }

    @Override
    public ShowDistrictMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_show_district,parent,false);

        return new ShowDistrictMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowDistrictMyViewHolder holder, final int position) {

        holder.districtNameTV.setText(showDistricts.get(position).getDistrictName());



        //item click
        holder.setItemClickListener(new ItemClickListener() {




            @Override
            public void onItemClick(int pos) {
                id=showDistricts.get(pos).getId().toString();


                    //Toast.makeText(context,""+id,Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(context,DistrictActivity.class);
                    intent.putExtra("district_id",id);
                    context.startActivity(intent);





            }
        });

    }




    @Override
    public int getItemCount() {
        return showDistricts.size();
    }





    public class ShowDistrictMyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView districtNameTV;

        ItemClickListener itemClickListener;

        public ShowDistrictMyViewHolder(View itemView) {
            super(itemView);


            districtNameTV=(TextView)itemView.findViewById(R.id.district_name_textview);

            itemView.setOnClickListener(this);




        }



        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }





}
