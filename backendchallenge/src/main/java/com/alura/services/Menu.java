package com.alura.services;

import java.util.Scanner;

import com.alura.api.ApiConsultationObject;

public class Menu {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("""
                    Ingrese la moneda a cambiar

                    1 - ARS (Peso argentino)
                    2 - BOB (Boliviano boliviano)
                    3 - BRL (Real brasileño)
                    4 - CLP (Peso chileno)
                    5 - COP (Peso colombiano)
                    6 - USD (Dólar estadounidense)
                    7 - Otra moneda
                    0 - Salir

                    """);
            option = scan.nextInt();
            scan.nextLine();
            
            switch (option) {
                case 1 -> {
                    String currency = "ARS";

                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
            }
        } while (option != 0);

        scan.close();
    }

    protected static String preOperation() {
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("""

                Ingrese la moneda a la que quiere cambiar

                1 - ARS (Peso argentino)
                2 - BOB (Boliviano boliviano)
                3 - BRL (Real brasileño)
                4 - CLP (Peso chileno)
                5 - COP (Peso colombiano)
                6 - USD (Dólar estadounidense)
                7 - Otra moneda

                """);

            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1 -> {
                    return "ARS";
                }
                case 2 -> {
                    return "BOB";
                }
                case 3 -> {
                    return "BRL";
                }
                case 4 -> {
                    return "CLP";
                }
                case 5 -> {
                    return "COP";
                }
                case 6 -> {
                    return "USD";
                }
                default -> {
                    System.out.println("Opcion incorrecta");
                    scan.close();
                    return null;
                }
            }
            
        } while (option != 0);
        
    }

    protected static Double operation(String currency, Double amount, String subCurrency) {

        ApiConsultationObject apiData = ApiConsultationObject.requestResult(currency);

        Double subCurrencyValue = apiData.getConversionRates().get(subCurrency);
        
        Double conversionResult = amount * subCurrencyValue;   

        return conversionResult;
    }

}
