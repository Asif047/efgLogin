package com.example.asif047.efglogin.Tourist;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asif047.efglogin.Hotel.RecyclerAdapter;
import com.example.asif047.efglogin.ItemClickListener;
import com.example.asif047.efglogin.R;

import java.util.List;

/**
 * Created by encrypt on 10/8/17.
 */

public class RecyclerAdapterTourist extends RecyclerView.Adapter<RecyclerAdapterTourist.TouristmyViewHolder> {

    private List<Tourist> tourists;

    private final Context context;

    //new starts
    private int phoneNumberPosition;
    //new ends

    public RecyclerAdapterTourist(Context ctx, List<Tourist> tourists) {
        this.context = ctx;
        this.tourists = tourists;
    }


    @Override
    public TouristmyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_tourist, parent, false);

        return new TouristmyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TouristmyViewHolder holder, int position) {


        holder.place_name.setText(tourists.get(position).getPlaceName());
        holder.phone.setText(tourists.get(position).getPhone());
        holder.address.setText(tourists.get(position).getAddress());
        holder.datails.setText(tourists.get(position).getDetails());


        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/" + tourists.get(position).getImage().toString()).into(holder.smallIV);

        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/" + tourists.get(position).getImage().toString()).into(holder.largeIV);


        //item click

//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(int pos) {
//                phone=tourists.get(pos).getPhone().toString();
//
//                //new starts
//                Toast.makeText(context,"phone:"+phone,Toast.LENGTH_LONG).show();
//                //new ends
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return tourists.size();
    }


    public class TouristmyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView place_name, phone, address, datails;
        ImageView smallIV, largeIV;

        ImageView phoneIV;


        ItemClickListener itemClickListener;


        public TouristmyViewHolder(View itemView) {
            super(itemView);


            place_name = (TextView) itemView.findViewById(R.id.place_name_textview_tourist);
            phone = (TextView) itemView.findViewById(R.id.phone_textview_tourist);
            address = (TextView) itemView.findViewById(R.id.address_textview_tourist);
            datails = (TextView) itemView.findViewById(R.id.details_textview_tourist);

            smallIV = (ImageView) itemView.findViewById(R.id.small_image_textview_tourist);
            largeIV = (ImageView) itemView.findViewById(R.id.large_image_imageview_tourist);

            phoneIV=(ImageView) itemView.findViewById(R.id.phone_imageview);


            phoneIV.setOnClickListener(this);

        }


        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {

            //this.itemClickListener.onItemClick(this.getLayoutPosition());

            if (view.getId() == phoneIV.getId()) {

                phoneNumberPosition = getAdapterPosition();

                //Toast.makeText(view.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();


                String phone_number = tourists.get(phoneNumberPosition).getPhone().toString();

                Toast.makeText(context, "Phone: " + phone_number, Toast.LENGTH_LONG).show();


                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone_number));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);




                //new ends





            } else {
                Toast.makeText(view.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }

        }
    }




}
