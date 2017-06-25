package com.weullermarcos.navegandocomparametros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtTexto;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = (EditText) findViewById(R.id.main_edtTexto);
        btnEnviar = (Button) findViewById(R.id.main_btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criando uma Intent, para navegar entre as telas
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Log.d("VAI COLOCAR NO EXTRA", edtTexto.getText().toString());

                //Preparando parametro para ser passado para a proxima tela
                intent.putExtra("MENSAGEM", edtTexto.getText().toString());

                //iniciando a proxima activity
                startActivity(intent);

            }
        });
    }
}
