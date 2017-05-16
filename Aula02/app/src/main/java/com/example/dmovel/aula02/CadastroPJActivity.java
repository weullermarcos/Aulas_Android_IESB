package com.example.dmovel.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroPJActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pj);

        findViewById(R.id.cadastro_pj_btnVoltar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
