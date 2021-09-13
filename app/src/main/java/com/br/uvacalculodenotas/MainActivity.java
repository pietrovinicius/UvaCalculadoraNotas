package com.br.uvacalculodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.br.uvacalculodenotas.Controler.controlador;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private EditText tb1, tb2, av2, av3;
    private Button btCalc;
    private TextView result;
    controlador control = new controlador();

    private String trb1 = "", trb2 = "", ava2 = "", ava3 = "";
    private double aux = 0;

    final DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        tb1 = (EditText) findViewById(R.id.edt_tb1);
        tb2 = (EditText) findViewById(R.id.edt_tb2);
        av2 = (EditText) findViewById(R.id.edt_av2);
        av3 = (EditText) findViewById(R.id.edt_av3);

        result = (TextView) findViewById(R.id.txt_result);

        btCalc = (Button) findViewById(R.id.btn_Calc);


        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    verificaDados();
                    control.inserirNotas(
                            Double.parseDouble(trb1),
                            Double.parseDouble(trb2),
                            Double.parseDouble(ava2),
                            Double.parseDouble(ava3)
                    );
                    control.calculaNfp();
                    aux = Double.parseDouble(control.calculaNfp());
                    String aux1 = df.format(aux);

                    if(aux<6)
                    {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                        alerta.setMessage("Aluno REPROVADO com média: " + aux1).setNeutralButton("OK" , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { }});
                        alerta.show();
                    }else{
                        result.setText(
                                aux1
                        );
                        AlertDialog.Builder alerta2 = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                        alerta2.setMessage("Parábens!!! APROVADO com média: " + aux1).setNeutralButton("OK" , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) { }});
                        alerta2.show();
                        limpaComponentes();
                    }
                    limpaComponentes();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("///////////////////Error : " + ex);
                    limpaComponentes();
                }
            }
        });
    }

    private void verificaDados() {
        if ((!tb1.getText().toString().isEmpty())) {
            aux = Double.parseDouble(tb1.getText().toString());
            if(aux>=0 && aux<11){
                trb1 = String.valueOf(aux);
            }else{
                //trb1 = "0";
                Toast.makeText(MainActivity.this, "Insira nota de 0 a 10!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Valor de Trabalho 1 inválido!", Toast.LENGTH_SHORT).show();
            trb1 = "";
        }

        if ((!tb2.getText().toString().isEmpty())) {
            aux = Double.parseDouble(tb2.getText().toString());
            if(aux>=0 && aux<11){
                trb2 = String.valueOf(aux);
            }else{
                Toast.makeText(MainActivity.this, "Insira nota de 0 a 10!", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(MainActivity.this, "Valor de Trabalho 2 inválido!", Toast.LENGTH_SHORT).show();
            trb2 = "";
        }

        if ((!av2.getText().toString().isEmpty())) {
            aux = Double.parseDouble(av2.getText().toString());
            if(aux>0 && aux<11){
                ava2 = String.valueOf(aux);
            }else{
                Toast.makeText(MainActivity.this, "Insira nota de 0 a 10!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Valor da Av2 inválido!", Toast.LENGTH_SHORT).show();
            ava2 = "";
        }

        if ((!av3.getText().toString().isEmpty())) {
            aux = Double.parseDouble(av3.getText().toString());
            if(aux>=0 && aux<11){
                ava3 = String.valueOf(aux);
            }else{
                Toast.makeText(MainActivity.this, "Insira nota de 0 a 10!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Valor da Av3 não utilizado!", Toast.LENGTH_SHORT).show();
            ava3 = "0";
            result.setText("");
        }
    }
        public void limpaComponentes(){
            //result.setText("");
            tb1.setText("");
            tb2.setText("");
            av2.setText("");
            av3.setText("");
        }
}
