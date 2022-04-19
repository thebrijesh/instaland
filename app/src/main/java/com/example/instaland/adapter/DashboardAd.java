package com.example.instaland.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instaland.R;
import com.example.instaland.model.DashboardModel;

import java.util.ArrayList;

public class DashboardAd extends RecyclerView.Adapter<DashboardAd.ViewHolder> {

    ArrayList<DashboardModel>list;
    Context context;

    public DashboardAd(ArrayList<DashboardModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_rv,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DashboardModel dashboardModel = list.get(position);
        holder.profile.setImageResource(dashboardModel.getProfile());
        holder.save.setImageResource(dashboardModel.getSave());
        holder.postimg.setImageResource(dashboardModel.getPostimg());
        holder.like.setText(dashboardModel.getLike());
        holder.share.setText(dashboardModel.getShare());
        holder.comment.setText(dashboardModel.getComment());
        holder.name.setText(dashboardModel.getName());
        holder.about.setText(dashboardModel.getAbout());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView profile,postimg,save;
        TextView like,comment,share,name,about;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_image);
            postimg = itemView.findViewById(R.id.postimg);
            save = itemView.findViewById(R.id.save);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
            name = itemView.findViewById(R.id.proffetion);
            about = itemView.findViewById(R.id.about);


        }
    }
}
