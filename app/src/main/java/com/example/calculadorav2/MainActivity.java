package com.example.calculadorav2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_sumar, btn_restar, btn_multiplicar, btn_dividir, btn_punto, btn_parentesisApertura, btn_parentesisiCierre, btn_clear;
    private TextView tv_valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = (FloatingActionButton) findViewById(R.id.btn_1);
        btn_2=(FloatingActionButton) findViewById(R.id.btn_2);
        btn_3 = (FloatingActionButton) findViewById(R.id.btn_3);
        btn_4=(FloatingActionButton) findViewById(R.id.btn_4);
        btn_5 = (FloatingActionButton) findViewById(R.id.btn_5);
        btn_6=(FloatingActionButton) findViewById(R.id.btn_6);
        btn_7 = (FloatingActionButton) findViewById(R.id.btn_7);
        btn_8=(FloatingActionButton) findViewById(R.id.btn_8);
        btn_9=(FloatingActionButton) findViewById(R.id.btn_9);
        btn_0=(FloatingActionButton) findViewById(R.id.btn_0);

        btn_sumar=(FloatingActionButton) findViewById(R.id.btn_sumar);
        btn_restar=(FloatingActionButton) findViewById(R.id.btn_restar);
        btn_multiplicar=(FloatingActionButton) findViewById(R.id.btn_multiplicar);
        btn_dividir=(FloatingActionButton) findViewById(R.id.btn_dividir);
        btn_parentesisApertura=(FloatingActionButton) findViewById(R.id.btn_parentesis_apertura);
        btn_parentesisiCierre=(FloatingActionButton) findViewById(R.id.btn_parentesis_cierre);
        btn_punto=(FloatingActionButton) findViewById(R.id.btn_punto);
        btn_clear = (FloatingActionButton) findViewById(R.id.btn_limpiar);

        tv_valores = (TextView) findViewById(R.id.tv_valores);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);


        btn_sumar.setOnClickListener(this);
        btn_restar.setOnClickListener(this);
        btn_dividir.setOnClickListener(this);
        btn_multiplicar.setOnClickListener(this);

        btn_parentesisApertura.setOnClickListener(this);
        btn_parentesisiCierre.setOnClickListener(this);
        btn_punto.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_0:
                tv_valores.setText(tv_valores.getText() + "0");
                break;

            case R.id.btn_1:
                tv_valores.setText(tv_valores.getText() + "1");
                break;

            case R.id.btn_2:
                tv_valores.setText(tv_valores.getText() + "2");
                break;

            case R.id.btn_3:
                tv_valores.setText(tv_valores.getText() + "3");
                break;

            case R.id.btn_4:
                tv_valores.setText(tv_valores.getText() + "4");
                break;

            case R.id.btn_5:
                tv_valores.setText(tv_valores.getText() + "5");
                break;

            case R.id.btn_6:
                tv_valores.setText(tv_valores.getText() + "6");
                break;

            case R.id.btn_7:
                tv_valores.setText(tv_valores.getText() + "7");
                break;

            case R.id.btn_8:
                tv_valores.setText(tv_valores.getText() + "8");
                break;

            case R.id.btn_9:
                tv_valores.setText(tv_valores.getText() + "9");
                break;

            case R.id.btn_sumar:
                tv_valores.setText(tv_valores.getText() + "+");
                break;

            case R.id.btn_restar:
                tv_valores.setText(tv_valores.getText() + "-");
                break;

            case R.id.btn_dividir:
                tv_valores.setText(tv_valores.getText() + "/");
                break;

            case R.id.btn_multiplicar:
                tv_valores.setText(tv_valores.getText() + "*");
                break;

            case R.id.btn_parentesis_apertura:
                tv_valores.setText(tv_valores.getText() + "(");
                break;

            case R.id.btn_parentesis_cierre:
                tv_valores.setText(tv_valores.getText() + ")");
                break;

            case R.id.btn_punto:
                tv_valores.setText(tv_valores.getText() + ".");
                break;

            case R.id.btn_limpiar:
                tv_valores.setText(null);
                break;


            case R.id.btn_calcular:
                System.out.print(tv_valores.getText());
                break;
        }
    }

    public void visualizarOperación(){

    }

}