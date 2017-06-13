package com.weullermarcos.contatos;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.weullermarcos.contatos.Models.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weullermarcos on 29/05/17.
 */

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter {


    public ContactRecyclerViewAdapter(List<Contato> contatos) {

    }

    //carrega o xib
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
