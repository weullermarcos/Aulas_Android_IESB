package com.example.weuller.exemplorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by weuller on 30/05/2017.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView contactNameLabel;
    public TextView contactEmailLabel;
    public ImageView contactImageView;
    public Contato contact;

    public ContactViewHolder(View itemView) {
        super(itemView);

        contactNameLabel = (TextView) itemView.findViewById(R.id.TextViewUserName);
        contactEmailLabel = (TextView) itemView.findViewById(R.id.TextViewUserEmail);
        contactImageView = (ImageView) itemView.findViewById(R.id.ImageViewUser);

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        params.setMargins(35,0,0,0);
    }

    @Override
    public void onClick(View v) {

    }
}
