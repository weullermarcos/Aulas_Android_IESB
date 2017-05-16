package com.example.dmovel.aula02;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //instanciando botões
    private Button cadastrarPF;
    private Button cadastrarPJ;
    private Button cadastrarConta;

    //metodos de criação da tela

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MAIN","PASSANDO PELO ONCREATE");

        //recuperando informações dos botões
        cadastrarPF = (Button) findViewById(R.id.main_cadastrar_pf);
        cadastrarPJ = (Button) findViewById(R.id.main_cadastrar_pj);
        cadastrarConta = (Button) findViewById(R.id.main_cadastrar_conta);

        //evento para o botão cadastraPF
        cadastrarPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroPFActivity.class);
                startActivity(intent);
            }
        });

        //evento para o botão cadastraPJ
        cadastrarPJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CadastroPJActivity.class);
                startActivity(intent);
            }
        });

        cadastrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CadastrarConta.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MAIN","PASSANDO PELO ONSTART");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MAIN","PASSANDO PELO ONSRESUME");
    }


    //metodos de destruir a tela:

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MAIN","PASSANDO PELO ONPAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MAIN","PASSANDO PELO ONPSTOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MAIN","PASSANDO PELO ONDESTROY");
    }

}
