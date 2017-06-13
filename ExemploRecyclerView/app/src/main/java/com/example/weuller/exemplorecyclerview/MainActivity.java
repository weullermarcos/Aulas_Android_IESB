package com.example.weuller.exemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewListaContatos;

    // /lista de contatos
    List<Contato> contatos = new ArrayList<>();

    //criando adapter
    ContactRecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contatos.add(new Contato("Weuller", "weuller@mail.com"));
        contatos.add(new Contato("Marcos", "marcos@mail.com"));
        contatos.add(new Contato("Gabriel", "gabriel@mail.com"));
        contatos.add(new Contato("Leonardo", "user@mail.com"));
        contatos.add(new Contato("Tiago", "user@mail.com"));
        contatos.add(new Contato("Nildes", "user@mail.com"));
        contatos.add(new Contato("Zé", "user@mail.com"));
        contatos.add(new Contato("Lucas", "user@mail.com"));

        //instanciando um novo adapter
        recyclerViewAdapter = new ContactRecyclerViewAdapter(this, contatos);

        //recuperando o componente RecyclerView da lista de contatos
        recyclerViewListaContatos = (RecyclerView) findViewById(R.id.RecyclerViewListaContatos);

        //setando adapter ao RecyclerView
        recyclerViewListaContatos.setAdapter(recyclerViewAdapter);

        //criando anumação default
        recyclerViewListaContatos.setItemAnimator(new DefaultItemAnimator());

        //criando o gerenciador de layout
        recyclerViewListaContatos.setLayoutManager(new LinearLayoutManager(this));


    }
}


























