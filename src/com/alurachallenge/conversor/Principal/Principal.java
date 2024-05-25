package com.alurachallenge.conversor.Principal;

import com.alurachallenge.conversor.Calculos.OperacionMoneda;
import com.alurachallenge.conversor.Consulta.ConsultaMoneda;
import com.alurachallenge.conversor.Modelos.Modelo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String mensaje = """
                *****************************************
                Bienvenid@ al conversor de Moneda
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción valida:
                *****************************************
                """;
        Scanner scanner = new Scanner(System.in);
        OperacionMoneda operacionMoneda = new OperacionMoneda();

        while(true){
            System.out.println(mensaje);
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 7) {
                System.out.println("Saliendo del programa");
                break;
            }

            System.out.println("Ingrese el valor que desea convertir: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            String base = "";
            String objetivo = "";

            switch (opcion) {
                case 1:
                    base = "USD";
                    objetivo = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    objetivo = "USD";
                    break;
                case 3:
                    base = "USD";
                    objetivo = "BRL";
                    break;
                case 4:
                    base = "BRL";
                    objetivo = "USD";
                    break;
                case 5:
                    base = "USD";
                    objetivo = "COP";
                    break;
                case 6:
                    base = "COP";
                    objetivo = "USD";
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            operacionMoneda.convertirMoneda(base, objetivo, valor);
        }
    }
}
