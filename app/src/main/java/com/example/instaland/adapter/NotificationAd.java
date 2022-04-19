package com.example.instaland.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instaland.R;
import com.example.instaland.model.NotificationModel;

import java.util.ArrayList;

public class NotificationAd extends RecyclerView.Adapter<NotificationAd.ViewHolder> {

    ArrayList<NotificationModel> list;
    Context context;

    public NotificationAd(ArrayList<NotificationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.notification_tab_view , parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
NotificationModel notificationModel = list.get(position);
holder.profile.setImageResource(notificationModel.getProfile());
holder.notification.setText(Html.fromHtml( notificationModel.getNotification()));
holder.time.setText(notificationModel.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView profile;
        private TextView notification,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_image);
            notification = itemView.findViewById(R.id.notification);
            time = itemView.findViewById(R.id.time);
        }
    }
}
