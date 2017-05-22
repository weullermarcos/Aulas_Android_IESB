package com.example.dmovel.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CadastrarConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_conta);

        Log.d("CONTA","PASSANDO PELO ONCREATE");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("CONTA","PASSANDO PELO ONSTART");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("CONTA","PASSANDO PELO ONRESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("CONTA","PASSANDO PELO ONPAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("CONTA","PASSANDO PELO ONPSTOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("CONTA","PASSANDO PELO ONDESTROY");
    }
}
