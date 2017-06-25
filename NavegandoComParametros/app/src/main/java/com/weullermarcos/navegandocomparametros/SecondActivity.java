package com.weullermarcos.navegandocomparametros;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText edtTexto;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtTexto = (EditText) findViewById(R.id.second_edtTexto);
        btnVoltar = (Button) findViewById(R.id.second_btnVoltar);

        //recuperando a intent passada para essa activity
         Bundle bundle = getIntent().getExtras();


        //verificando se existe um parametro com a chave passada
        if(bundle.containsKey("MENSAGEM")){

            Log.d("ACHOU A MENSAGEM", "");

            //recupernando valor passado
            String message = bundle.getString("MENSAGEM");

            Log.d("MENSAGEM: ", message);

            //setando valor recuperado
            edtTexto.setText(message);
        }

        Log.d("NAO ACHOU A MENSAGEM", "");



        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //finaliza a ctivity
                finish();
            }
        });


    }
}
