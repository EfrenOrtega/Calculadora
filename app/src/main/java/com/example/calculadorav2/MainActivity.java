package com.example.calculadorav2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_sumar, btn_restar, btn_multiplicar, btn_dividir, btn_punto, btn_parentesisApertura, btn_parentesisiCierre, btn_clear, btn_Calcular;
    private TextView tv_valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2=(Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4=(Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6=(Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8=(Button) findViewById(R.id.btn_8);
        btn_9=(Button) findViewById(R.id.btn_9);
        btn_0=(Button) findViewById(R.id.btn_0);

        btn_sumar=(Button) findViewById(R.id.btn_sumar);
        btn_restar=(Button) findViewById(R.id.btn_restar);
        btn_multiplicar=(Button) findViewById(R.id.btn_multiplicar);
        btn_dividir=(Button) findViewById(R.id.btn_dividir);
        btn_parentesisApertura=(Button) findViewById(R.id.btn_parentesis_apertura);
        btn_parentesisiCierre=(Button) findViewById(R.id.btn_parentesis_cierre);
        btn_punto=(Button) findViewById(R.id.btn_punto);
        btn_clear = (Button) findViewById(R.id.btn_limpiar);
        btn_Calcular = (Button) findViewById(R.id.btn_calcular);

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
        btn_Calcular.setOnClickListener(this);

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

                if(!validarExpresión()) return;
                ManejoParentesis();
                break;
        }
    }

    public boolean validarExpresión(){
        //Antes de Calcular verifico que la expresión ingresada este correcta siguiendo el siguiente patron:
        //( (parentesis*(num*.num*)parentesis*) (operador){0,1} (parentesis*(num*.num*)parentesis*){1,} )*
        String regex = "^((\\()*([0-9]*(\\.){0,1}[0-9]*)(\\))*([\\+|\\-|\\*|\\/]){0,1}((\\()*[0-9]*(\\.){0,1}[0-9]{1,}(\\))*)){1,}$";
        if(!Pattern.matches(regex, tv_valores.getText())){
            Toast.makeText(this, "Verifique que su Expresión sea Correcta", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void ManejoParentesis(){
        final String regex = "[\\(].{0,}([\\(].{0,}[\\)]).{0,}[\\)]";
        final String string = "(3*(2+2))";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }

    public void visualizarOperación(){

    }

}