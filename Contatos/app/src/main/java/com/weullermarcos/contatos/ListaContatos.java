package com.weullermarcos.contatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.weullermarcos.contatos.Models.Contato;

import java.util.ArrayList;
import java.util.List;

public class ListaContatos extends AppCompatActivity {

    ContactRecyclerViewAdapter recycleViewAdapter;
    List<Contato> contactBook = new ArrayList<>();
    private FirebaseDatabase database;
    DatabaseReference contactBookRootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);


        recycleViewAdapter = new ContactRecyclerViewAdapter(contactBook);

        //recuperando o recyclerView da classe R
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewContatos);

        //setando o adpatador
        recyclerView.setAdapter(recycleViewAdapter);

        //setando a animacao
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
