package com.example.testetratamentoerros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList notas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notas = new ArrayList();
    }



    public float divide(float numerador, float denominador) throws Exception {
        if(denominador==0){
            Exception e = new Exception("Denominador não pode ser zero");
            throw e;
        }else if(numerador<0){
            Exception e = new Exception("Numerador tem que ser maior que zero");
            throw e;
        }
        else{
            return numerador/denominador;
        }
    }

    public void mandaCalcular(View view) {
        EditText pegaNumerador = findViewById(R.id.et_pegaNumerador);
        EditText pegaDenominador = findViewById(R.id.et_pegaDenominador);
        float numerador=0;
        try{
             numerador = Float.parseFloat(pegaNumerador.getText().toString());
        }catch (Exception e){
            TextView mostraErro = findViewById(R.id.tv_mostraErro);
            mostraErro.setText("O numerador precisa ser um número");
        }

        float denominador = Float.parseFloat(pegaDenominador.getText().toString());


        try{
            float resultado = divide(numerador,denominador);
            TextView mostraResultado = findViewById(R.id.tv_mostraResultado);
            mostraResultado.setText(String.valueOf(resultado));
        }catch (Exception e){
            TextView mostraErro = findViewById(R.id.tv_mostraErro);
            mostraErro.setText(e.getMessage());
        }



    }
}
