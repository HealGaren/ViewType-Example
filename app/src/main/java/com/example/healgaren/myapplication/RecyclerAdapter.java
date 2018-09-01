package com.example.healgaren.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Profile myProfile;

    private List<Profile> list = new ArrayList<>();

    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_PROFILE = 2;

    public void addProfile(Profile profile) {
        list.add(profile);
    }

    public void setMyProfile(Profile profile) {
        myProfile = profile;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            if (viewType == VIEW_TYPE_HEADER) {
                View view = inflater.inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(view);
            }

            else {
                View view = inflater.inflate(R.layout.item_profile, parent, false);
                return new ProfileViewHolder(view);
            }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 2) return VIEW_TYPE_HEADER;
        return VIEW_TYPE_PROFILE;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder_, int position) {

        if (holder_.getItemViewType() == VIEW_TYPE_HEADER) {
            HeaderViewHolder holder = (HeaderViewHolder)holder_;

            holder.headerText.setText(position == 0 ? "내 프로필" : "친구 목록");
        }

        else {

            ProfileViewHolder holder = (ProfileViewHolder)holder_;

            Profile profile = position == 1 ?
                    myProfile : list.get(position - 3);

            Glide
                    .with(holder.itemView)
                    .load(profile.getImageURL())
                    .into(holder.profileImg);

            holder.profileNameText.setText(profile.getName());

        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 3;
    }



    class ProfileViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImg;
        TextView profileNameText;


        public ProfileViewHolder(View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.img_profile);
            profileNameText = itemView.findViewById(R.id.text_profile_name);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView headerText;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerText = itemView.findViewById(R.id.text_profile_name);
        }
    }
}
