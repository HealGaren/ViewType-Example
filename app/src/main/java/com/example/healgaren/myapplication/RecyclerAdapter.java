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

    private List<RecyclerModel> list = new ArrayList<>();

    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_PROFILE = 2;

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
        return list.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder_, int position) {

        if (holder_.getItemViewType() == VIEW_TYPE_HEADER) {
            HeaderViewHolder holder = (HeaderViewHolder)holder_;

            String headerText = (String)list.get(position).getModel();
            holder.headerText.setText(headerText);
        }

        else {

            ProfileViewHolder holder = (ProfileViewHolder)holder_;
            Profile profile = (Profile)list.get(position).getModel();

            Glide
                    .with(holder.itemView)
                    .load(profile.getImageURL())
                    .into(holder.profileImg);

            holder.profileNameText.setText(profile.getName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
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
