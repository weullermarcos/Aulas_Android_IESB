package com.example.weullermarcos.usandovolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView txtResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResposta = (TextView) findViewById(R.id.txtResposta);

        txtResposta.setText("Iniciando...");

        Log.d("TESTE","INICIANDO");


//        Requisição simples


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://mobile-aceite.tcu.gov.br:80/nossaEscolaRS/rest/escolas";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                txtResposta.setText("Resposta: " + response.substring(0, 500));
                Log.d("TESTE","DEU CERTO");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                txtResposta.setText("Deu errado...");
                Log.d("TESTE","DEU ERRADO");

            }
        });

        Log.d("TESTE","ADICIONANDO A FILA");

        //adiciona a string de requisição a fila de execução
        queue.add(stringRequest);

    }
}
