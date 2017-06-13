package com.example.weuller.exemplorecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by weuller on 30/05/2017.
 */

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context context;
    private List<Contato> contatos;

    public ContactRecyclerViewAdapter(Context context, List<Contato> contatos) {

        this.context = context;
        this.contatos = contatos;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //cabalacho muito doido
        View view = LayoutInflater.from(context).inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        Contato contact = contatos.get(position);

        holder.contactNameLabel.setText(contact.getNome());
        holder.contactEmailLabel.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.contatos.size();
    }
}











