package com.alurachallenge.conversor.Calculos;

import com.alurachallenge.conversor.Consulta.ConsultaMoneda;
import com.alurachallenge.conversor.Modelos.Modelo;

public class OperacionMoneda {
    private final ConsultaMoneda consulta;

    public OperacionMoneda(){
        this.consulta = new ConsultaMoneda();
    }

    public void convertirMoneda(String base, String objetivo, double valor){
        try{
            Modelo modelo = consulta.buscarMoneda(base);
            if (modelo.conversion_rates().containsKey(objetivo)){
                double tasaConversion = modelo.conversion_rates().get(objetivo);
                double valorConvertido = valor * tasaConversion;
                System.out.println("El valor de " + valor + " " + base + " corresponde al valor final de =>> " + valorConvertido + " " + objetivo);
            }else{
                System.out.println("No se encontró la tasa de conversión para la moneda objetivo.");
            }
        }catch (Exception e){
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
