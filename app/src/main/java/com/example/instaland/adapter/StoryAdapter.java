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
import com.example.instaland.model.story;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    ArrayList<story> list;
    Context context;

    public StoryAdapter(ArrayList<story> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.story,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        story story = list.get(position);
        holder.storyimg.setImageResource(story.getStory());
        holder.storylive.setImageResource(story.getStorylive());
        holder.storyname.setText(story.getStoryname());
        holder.profile.setImageResource(story.getProfile_image());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView storyimg,profile,storylive;
        TextView storyname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storyimg = itemView.findViewById(R.id.postimg);
            profile = itemView.findViewById(R.id.profile_image);
            storylive = itemView.findViewById(R.id.storylive);
            storyname = itemView.findViewById(R.id.storynames);
        }
    }
}
