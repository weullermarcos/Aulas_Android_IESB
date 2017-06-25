package com.weullermarcos.calculadorasimples;

import android.renderscript.Double2;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNumero1;
    EditText edtNumero2;
    EditText edtResultado;
    Button btnAdd;
    Button btnSubtract;
    Button btnMult;
    Button btnDiv;

    boolean isEmpty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);
        edtResultado = (EditText) findViewById(R.id.edtResult);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMultip);

        String v1 = edtNumero1.getText().toString();
        String v2 = edtNumero2.getText().toString();

        //verifica se tem algum campo vazio
//        if(v1.trim().isEmpty() || v2.trim().isEmpty()){
//            isEmpty = true;
//        }
//        else{
//            isEmpty = false;
//        }

        //criando evento de Click para o
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEmpty) {
                    showMessage();
                    return;
                }

                Double valor1 = Double.parseDouble(edtNumero1.getText().toString());
                Double valor2 = Double.parseDouble(edtNumero2.getText().toString());

                double resultado = valor1 + valor2;
                edtResultado.setText(String.valueOf(resultado));

            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEmpty) {
                    showMessage();
                    return;
                }

                Double valor1 = Double.parseDouble(edtNumero1.getText().toString());
                Double valor2 = Double.parseDouble(edtNumero2.getText().toString());

                double resultado = valor1 - valor2;
                edtResultado.setText(String.valueOf(resultado));

            }
        });
    }

    private void showMessage(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Erro");
        builder.setMessage("Favor preencher todos os campos");
        builder.setNeutralButton("OK", null);
        builder.show();

    }
}
