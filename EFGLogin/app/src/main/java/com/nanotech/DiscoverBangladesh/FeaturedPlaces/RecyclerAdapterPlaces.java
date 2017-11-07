package com.nanotech.DiscoverBangladesh.FeaturedPlaces;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nanotech.DiscoverBangladesh.R;
import com.nanotech.DiscoverBangladesh.ItemClickListener;

import java.util.List;

/**
 * Created by encrypt on 10/17/17.
 */

public class RecyclerAdapterPlaces extends RecyclerView.Adapter<RecyclerAdapterPlaces.PlacesMyViewHolder> {


    private final Context context;

    //new starts
    private int phoneNumberPosition;
    //new ends


    private List<FeaturedPlaces> featuredPlaces;

    public RecyclerAdapterPlaces(Context ctx,List<FeaturedPlaces> featuredPlaces)
    {
        this.context = ctx;
        this.featuredPlaces=featuredPlaces;
    }


    @Override
    public PlacesMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_places,parent,false);

        return new PlacesMyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PlacesMyViewHolder holder, int position) {



        holder.place_name.setText(featuredPlaces.get(position).getPlaceName());
        holder.phone.setText(featuredPlaces.get(position).getPhone());
        holder.address.setText(featuredPlaces.get(position).getAddress());
        holder.datails.setText(featuredPlaces.get(position).getDetails());


        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/" + featuredPlaces.get(position).getImage().toString()).into(holder.smallIV);

        Glide.with(context).load("http://discover.nanotech.com.bd/place_images/" + featuredPlaces.get(position).getImage().toString()).into(holder.largeIV);



        makeTextViewResizable(holder.datails, 3, "View More", true);

    }

    @Override
    public int getItemCount() {
        return featuredPlaces.size();
    }




    public class PlacesMyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView place_name, phone, address, datails;
        ImageView smallIV, largeIV;

        ImageView phoneIV;


        ItemClickListener itemClickListener;



        public PlacesMyViewHolder(View itemView) {
            super(itemView);






            place_name = (TextView) itemView.findViewById(R.id.place_name_textview_places);
            phone = (TextView) itemView.findViewById(R.id.phone_textview_places);
            address = (TextView) itemView.findViewById(R.id.address_textview_places);
            datails = (TextView) itemView.findViewById(R.id.details_textview_places);

            smallIV = (ImageView) itemView.findViewById(R.id.small_image_imageview_places);
            largeIV = (ImageView) itemView.findViewById(R.id.large_image_imageview_places);

            phoneIV=(ImageView) itemView.findViewById(R.id.phone_imageview);


            phoneIV.setOnClickListener(this);




        }


        @Override
        public void onClick(View view) {




            if (view.getId() == phoneIV.getId()) {

                phoneNumberPosition = getAdapterPosition();

                //Toast.makeText(view.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();


                String phone_number = featuredPlaces.get(phoneNumberPosition).getPhone().toString();

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






    //new starts
    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    int lineEndIndex = tv.getLayout().getLineEnd(0);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                }
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {
            ssb.setSpan(new ClickableSpan() {

                @Override
                public void onClick(View widget) {

                    if (viewMore) {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, -1, "View Less", false);
                    } else {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, 3, "View More", true);
                    }

                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }



    //new ends










}
