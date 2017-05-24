package com.weullermarcos.contatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.main_entrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Chamando intent de forma explicita
                //Intent intent = new Intent(MainActivity.this, ListaContatos.class);
                //startActivity(intent);

                //chamando intent de forma implicita - Olhar configuração no AndroidManifest.xml
                Intent intent = new Intent("LISTA_CONTATOS");
                intent.addCategory("LISTA_CONTATOS");
                startActivity(intent);


            }
        });

    }
}
