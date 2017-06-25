package com.weullermarcos.listviewandspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lstDados;
    Spinner spnOpcoes;
    Button btnAdicionar;
    Button btnRemover;
    EditText edtValor;

    //criando um novo arrayAdapter, para preencher a lista de opcoes
    ArrayAdapter<String> adpOpcoes;

    //criando um novo arrayAdapter, para preencher a lista de Dados
    ArrayAdapter<String> adpDados ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = (EditText) findViewById(R.id.edtValor);
        lstDados = (ListView) findViewById(R.id.lstDados);
        spnOpcoes = (Spinner) findViewById(R.id.spnOpcoes);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);
        btnRemover = (Button) findViewById(R.id.btnRemover);

        // instanciando um novo adapter com o layout padrao do spinner do android
        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //setando layout do dropdown
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //setando o adaptador para o spinner
        spnOpcoes.setAdapter(adpOpcoes);

        //adicionando elementos ao spinner
        adpOpcoes.add("Opção 1");
        adpOpcoes.add("Opção 2");
        adpOpcoes.add("Opção 3");
        adpOpcoes.add("Opção 4");

        adpDados = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);

        btnAdicionar.setOnClickListener(this);
        btnRemover.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        //verifica qual botao chamou o evento
        if(view == btnAdicionar){

            String item = edtValor.getText().toString();

            item += " - " + spnOpcoes.getSelectedItem();

            //adicionando item a lista de dados
            adpDados.add(item);

        }
        else {
            if(adpDados.getCount() > 0){
                String item = adpDados.getItem(0);
                adpDados.remove(item);
            }
        }
    }
}
