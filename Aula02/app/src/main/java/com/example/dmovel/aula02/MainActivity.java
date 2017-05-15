package com.example.dmovel.aula02;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button cadatrarPf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadatrarPf = (Button) findViewById(R.id.main_cadastra_pf);

        cadatrarPf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroPFActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("TAG1","PASSANDO PELO ONPAUSE");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("TAG2","");
    }
}
