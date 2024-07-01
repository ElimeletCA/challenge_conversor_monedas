package com.elimeletca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Source source = new Source();
        Exchange exchange = new Exchange(source);
        int opcion = 0;
        double cantidad;
        String menu = """
          ******************** Bienvenido/a al Conversor de Monedas ********************   
          1) Dólar >> Peso dominicano 
          2) Peso dominicano >> Dólar
          3) Dólar >> Peso argentino
          4) Peso argentino >> Dólar
          5) Dólar >> Peso colombiano
          6) Peso colombiano >> Dólar
          7) Dólar >> Peso mexicano
          8) Peso mexicano >> Dólar
          9) Salir
          ******************************************************************************          
          """;
        Scanner entrada = new Scanner(System.in);

        while (opcion != 9) {
            System.out.println(menu);
            System.out.println("Indique el tipo de conversión que desea realizar: ");
            try {
                opcion = entrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 9.");
                entrada.next();
                continue;
            }

            if (opcion >= 1 && opcion <= 8) {
                System.out.println("Cantidad a convertir: ");
                try {
                    cantidad = entrada.nextDouble();
                } catch (InputMismatchException e){
                    System.out.println("Ingrese una cantidad que sea correcta");
                    entrada.next();
                    continue;
                }
                entrada.nextLine();

                String fromCurrency = "";
                String toCurrency = "";

                switch (opcion) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "DOP";
                        break;
                    case 2:
                        fromCurrency = "DOP";
                        toCurrency = "USD";
                        break;
                    case 3:
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                        break;
                    case 4:
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                        break;
                    case 5:
                        fromCurrency = "USD";
                        toCurrency = "COP";
                        break;
                    case 6:
                        fromCurrency = "COP";
                        toCurrency = "USD";
                        break;
                    case 7:
                        fromCurrency = "USD";
                        toCurrency = "MXN";
                        break;
                    case 8:
                        fromCurrency = "MXN";
                        toCurrency = "USD";
                        break;
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(exchange.getConvertValues(fromCurrency,toCurrency,cantidad)+'\n');

            } else if (opcion == 9) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 9.");
            }
        }

        entrada.close();
    }
}