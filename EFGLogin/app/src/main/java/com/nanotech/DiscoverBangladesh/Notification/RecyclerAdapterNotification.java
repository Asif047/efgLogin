package com.nanotech.DiscoverBangladesh.Notification;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nanotech.DiscoverBangladesh.R;

import java.util.List;

/**
 * Created by admin on 10/12/2017.
 */

public class RecyclerAdapterNotification extends RecyclerView.Adapter<RecyclerAdapterNotification.NotificationMyViewHolder> {

    private List<Notification> notifications;

    public RecyclerAdapterNotification(List<Notification>notifications)
    {
        this.notifications=notifications;
    }

    @Override
    public NotificationMyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_notification,parent,false);

        return new NotificationMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationMyViewHolder holder, int position) {

        holder.title.setText(notifications.get(position).getTitle());
        holder.details.setText(notifications.get(position).getDetails());

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }



    public class NotificationMyViewHolder extends RecyclerView.ViewHolder
    {

        TextView title,details;

        public NotificationMyViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.title_textview_notification);
            details=(TextView)itemView.findViewById(R.id.details_textview_notification);
        }
    }



}
