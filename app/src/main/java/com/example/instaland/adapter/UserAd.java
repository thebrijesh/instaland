package com.example.instaland.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instaland.R;
import com.example.instaland.model.user;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAd extends RecyclerView.Adapter<UserAd.ViewHolder> {

    Context context;
    ArrayList<user> list;

    public UserAd(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_sample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        user user = list.get(position);

        Picasso.get().load(user.getProfile_image()).placeholder(R.drawable.home).into(holder.profile_image);
        holder.name.setText(user.getName());
        holder.userproff.setText(user.getProffetion());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView name;
        private final TextView userproff;
        private final ImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            userproff = itemView.findViewById(R.id.userproff);
            profile_image = itemView.findViewById(R.id.profile_image);
            
        }
    }
}
