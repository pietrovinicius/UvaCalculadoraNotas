package com.br.uvacalculodenotas.Model;

public class calculaNFP {
    nota nota1 =  new nota();

    public void inserirNotas(double tb1, double tb2, double nt1, double nt2, double nt3){
        nota1.setTb1(tb1);
        nota1.setTb2(tb2);
        nota1.setNt2(nt2);
        nota1.setNt3(nt3);
    }

    public double calculaNFP1(){
        nota1.setNt1((nota1.getTb1() + nota1.getTb2())/2);
        if (nota1.getNt1()>0){
            if ((nota1.getNt2() >= 5) || (nota1.getNt3() >= 5)){
                modelo_padrao();
            }else{
                if((nota1.getNt2()<5) || (nota1.getNt3()<5)) {
                    //NFp = (A1 x 0,4) + (A2 ou A3 x 0,6)/2
                    System.out.println("////////NOTA DA A1= " + nota1.getNt1());
                    if(nota1.getNt2() > nota1.getNt3()){
                        modelo_A2();
                    }else{
                        modelo_A3();
                    }

                }
            }
        }else{
            if(nota1.getNt2()>nota1.getNt3()){
                modelo_A2();
            }else{
                modelo_A3();
            }
        }
        return  nota1.getResul();
    }
    public void inserirNotas(double tb1, double tb2, double av2, double av3) {
        nota1.setTb1(tb1);
        nota1.setTb2(tb2);
        nota1.setNt2(av2);
        nota1.setNt3(av3);
    }

    public void valores(){
        String s = nota1.toString();
        System.out.println(s);
    }

    private void modelo_padrao(){
        nota1.setResul(
                ((nota1.getNt1()*0.4))
                        +
                        (nota1.getNt2()*0.6)
        );
    }

    private void modelo_A2(){
        nota1.setResul(
                ((nota1.getNt1()*0.4))
                        +
                        ((nota1.getNt2()*0.6)/2)
        );
    }

    private void modelo_A3(){
        nota1.setResul(
                ((nota1.getNt1()*0.4))
                        +
                        ((nota1.getNt3()*0.6)/2)
        );
    }


}
