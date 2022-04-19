package com.example.instaland.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instaland.R;
import com.example.instaland.adapter.FriendAd;
import com.example.instaland.model.FriendModel;
import com.example.instaland.model.user;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<FriendModel> list;
    private ImageView uploadimage;
    private ImageView coverphotos;

    private FirebaseAuth mAuth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    private TextView textView,textView2;
    private ImageView profile_image;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        recyclerView = view.findViewById(R.id.friendrv);
        textView = view.findViewById(R.id.textView);
        textView2 = view.findViewById(R.id.textView2);
        uploadimage = view.findViewById(R.id.uploadimage);
        coverphotos = view.findViewById(R.id.coverphoto);
        profile_image = view.findViewById(R.id.profile_image);

        database.getReference().child("Users").child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    user user = snapshot.getValue(com.example.instaland.model.user.class);
                    Picasso.get().load(user.getCoverphoto()).placeholder(R.drawable.home).into(coverphotos);
                    Picasso.get().load(user.getProfile_image()).placeholder(R.drawable.home).into(profile_image);
                    textView.setText(user.getName());
                    textView2.setText(user.getProffetion());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);
            }
        });

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);
            }
        });


        list = new ArrayList<>();
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));
        list.add(new FriendModel(R.drawable.home));

        FriendAd friendAd = new FriendAd(list, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(friendAd);
        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 11){
            if (data.getData() != null) {
                Uri uri = data.getData();
                coverphotos.setImageURI(uri);

                StorageReference reference = storage.getReference().child("cover_photo").child(FirebaseAuth.getInstance().getUid());
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getContext(), "File Uplode Save", Toast.LENGTH_SHORT).show();
                    }
                });

                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        database.getReference().child("Users").child(mAuth.getUid()).child("coverphoto").setValue(uri.toString());

                    }

                });

            }
        }else {
            if (data.getData() != null) {
                Uri uri = data.getData();
                profile_image.setImageURI(uri);

                StorageReference reference = storage.getReference().child("profile_image").child(FirebaseAuth.getInstance().getUid());
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getContext(), "File Uplode Save", Toast.LENGTH_SHORT).show();
                    }
                });

                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        database.getReference().child("Users").child(mAuth.getUid()).child("profile_image").setValue(uri.toString());

                    }

                });

            }
        }

    }
}