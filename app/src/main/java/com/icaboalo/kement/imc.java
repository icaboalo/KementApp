package com.icaboalo.kement;

/**
 * Created by icaboalo on 7/2/2015.
 */
public class imc {
    private double mBalance;
    public final static String sobrepeso = ("SobrePeso");
    public final static String obesidadmoderada = ("Obesidad moderada");
    public final static String obesidadmorbida = ("Obesidad morbida");
    public final static String desnutricion = ("Desnutricion");
    public final static String ideal = ("Ideal");

    public void BMI(double  weightAmount, double heightAmount){
        mBalance = weightAmount / (heightAmount*heightAmount)*10000;
    }
    public double getBalance(){
        return mBalance;
    }
}
