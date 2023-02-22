package com.example.calculadorav2;

import android.widget.Toast;

import java.util.Stack;
import java.util.regex.Pattern;

public class Analizador {
    private String expresion;
    private Stack<String> stackOperadores = new Stack<String>();
    private Stack<Float> stackOperandos =  new Stack<Float>();

    public void Analizador(String exp){
        this.expresion = exp.trim();
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public float evaluar(){
        for (int i=0; i< this.expresion.length(); i++){
            char caracterActual = this.expresion.charAt(i);

            String operadoresDelimitadores = "[\\(|\\)|\\+|\\-|\\/|\\*|\\^|\\.]";
            if(Pattern.matches(operadoresDelimitadores, new Character(caracterActual).toString())){

               if(this.stackOperadores.size()!=0){

                   String soloOperadores = "[\\.|\\+|\\-|\\/|\\*|\\^]";
                   if(Pattern.matches(soloOperadores, this.stackOperadores.peek()) && Pattern.matches(soloOperadores, new Character(caracterActual).toString())){
                        if(this.evaluarJerarquía(new Character(caracterActual).toString())){
                            this.stackOperandos.push(this.operar());
                        }
                   }
               }

               this.stackOperadores.push(new Character(caracterActual).toString());

               if(new Character(caracterActual).toString().equals(")")){
                   this.stackOperadores.pop();

                   String soloOperadores = "^[\\.|\\+|\\-|\\/|\\*|\\^]$";
                   if(Pattern.matches(soloOperadores, this.stackOperadores.peek())){
                        this.stackOperandos.push(this.operar());
                   }

                   while(true){
                       if(this.stackOperadores.peek().equals("(")){
                           this.stackOperadores.pop();
                           break;
                       }else{
                           this.stackOperandos.push(this.operar());
                       }
                   }

               }
            }else{

                if(i>0 && caracterActual != '.'){
                    String numeros ="^[0-9]$";
                    if(Pattern.matches(numeros,new Character(this.expresion.charAt(i-1)).toString())){

                        String first = Integer.toString(Math.round(this.stackOperandos.pop()));
                        String nuevoValor = new Character(caracterActual).toString();

                        this.stackOperandos.push(Float.parseFloat(first.concat(nuevoValor)));
                    }else{
                        this.stackOperandos.push(Float.parseFloat(new Character(caracterActual).toString()));
                    }
                }else{
                    this.stackOperandos.push(Float.parseFloat(new Character(caracterActual).toString()));
                }

            }

        }

        if(this.stackOperadores.size() != 0){

            int size = this.stackOperadores.size();
            for(int i=0; i<size; i++){
                this.stackOperandos.push(this.operar());
            }
        }

        System.out.println(this.stackOperandos.peek());
        return this.stackOperandos.peek();
    }


    public boolean evaluarJerarquía(String caracterActual){
        if(this.jerarquiaAritmetica(this.stackOperadores.peek()) < this.jerarquiaAritmetica(caracterActual)){
            return false;
        }

        return true;
    }

    public int jerarquiaAritmetica(String caracterActual){
        switch (caracterActual){
            case "+":
                return 0;

            case "-":
                return 0;

            case "*":
                return 1;

            case "/":
                return 1;

            case "^":
                return 2;

            case ".":
                return 3;

            default:
                return -1;
        }
    }

    public float operar(){

        float operando2 = this.stackOperandos.pop();
        String operador = this.stackOperadores.pop();
        float operando1 = this.stackOperandos.pop();

        float result = 0;

        switch (operador){
            case "+":
                result = operando1 + operando2;
                break;

            case "-":
                result = operando1 - operando2;
                break;

            case "*":
                result = operando1 * operando2;
                break;

            case "/":
                result = operando1 / operando2;
                break;

            case "^":
                result = (float) (Math.pow(operando1,operando2));
                break;

            case ".":
                String operando_1_str = Integer.toString(Math.round(operando1));
                String operando_2_str =Integer.toString(Math.round(operando2));
                result = Float.parseFloat(operando_1_str + operador + operando_2_str);
                System.out.println("Este caracter es punto " + result);
        }

        return result;
    }

}
