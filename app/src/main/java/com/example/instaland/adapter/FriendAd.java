//package com.example.instaland.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Adapter;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//
//
//import com.example.instaland.R;
//import com.example.instaland.model.FriendModel;
//
//import java.util.ArrayList;
//
//public class FriendAd extends Adapter<FriendAd.ViewHolder> {
//
//    ArrayList<FriendModel> list;
//    Context context;
//
//    public FriendAd(ArrayList<FriendModel> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//View view = LayoutInflater.from(context).inflate(R.layout.friend_rv,null);
//
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        FriendModel friendModel = list.get(position);
//        holder.profile.setImageResource(friendModel.getProfile());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends ViewHolder{
//
//        private final ImageView profile;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            profile = itemView.findViewById(R.id.friendimg);
//
//
//        }
//    }
//}
