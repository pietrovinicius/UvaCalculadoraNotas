package com.br.uvacalculodenotas.Controler;

import com.br.uvacalculodenotas.Model.calculaNFP;

public class controlador {

    calculaNFP calculaNFP = new calculaNFP ();

    public void inserirNotas(double tb1 , double tb2 , double av2 , double av3){
        calculaNFP.inserirNotas(tb1 , tb2 , av2 , av3);
        calculaNFP.valores();
    }

    public String calculaNfp(){
        double resultado = calculaNFP.calculaNFP1();
        String resul = String.valueOf(resultado);
        return resul;
    }

}
