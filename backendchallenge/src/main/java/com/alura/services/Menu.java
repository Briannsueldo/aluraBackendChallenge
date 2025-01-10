package com.alura.services;

import java.util.InputMismatchException;
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
                    8 - Ver historial de cambio
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
                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 2 -> {
                    String currency = "BOB";

                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();
                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 3 -> {
                    String currency = "BRL";

                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();
                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 4 -> {
                    String currency = "CLP";

                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();
                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 5 -> {
                    String currency = "COP";

                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();
                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 6 -> {
                    String currency = "USD";

                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();
                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 7 -> {
                    String currency = searchCurrency(scan);

                    /* if(inputError) {
                        System.out.println("La moneda unicamente debe contener letras");
                        continue;
                    } */

                    if(currency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        continue;
                    }
                    
                    System.out.println("Ingrese el monto a cambiar");
                    Double amount = scan.nextDouble();

                    String subCurrency = preOperation();

                    if(subCurrency == null) {
                        System.out.println("Moneda no encontrada, por favor vuelva a comenzar");
                        break;
                    }

                    Double conversionResult = operation(currency, amount, subCurrency);

                    System.out.println("Conversion exitosa! " + amount + " " + currency + " = " + conversionResult + " " + subCurrency);
                }
                case 8 -> {
                    showHistory();
                }
                default -> {
                    System.out.println("Opcion incorrecta, intente nuevamente");
                }
            }
        } while (option != 0);
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
                case 7 -> {
                    String subCurrency = searchCurrency(scan);

                    if(subCurrency == null) {
                        return null;
                    }

                    return subCurrency.toUpperCase();
                }
                default -> {
                    System.out.println("Opcion incorrecta");
                    scan.close();
                    return null;
                }
            }
            
        } while (option != 0);
        
    }

    protected static String searchCurrency(Scanner scan) {
        String currency;

        try {
            System.out.println("Digite las 3 iniciales de la moneda");
            currency = scan.nextLine();

            if (!currency.matches("[a-zA-Z]+")) {
                System.out.println("La moneda unicamente debe contener letras");
                return null;
            }

            ApiConsultationObject apiData = ApiConsultationObject.requestResult(currency);

            if (apiData.getResult().equals("error")) {
                return null;
            } else {
                return currency.toUpperCase();
            }

        } catch (InputMismatchException e) {
            e.getMessage();
            return null;
        }
        
    }

    protected static Double operation(String currency, Double amount, String subCurrency) {

        ApiConsultationObject apiData = ApiConsultationObject.requestResult(currency);

        Double subCurrencyValue = apiData.getConversionRates().get(subCurrency);
        
        Double conversionResult = amount * subCurrencyValue;

        String historyEntry = amount + " " + currency + " ---> " + subCurrency + " " + conversionResult;
        History.newHistoryEntry(historyEntry);
        Time.saveDate();

        return conversionResult;
    }

    protected static void showHistory() {
        if (History.conversionHistory.size() == 0) {
            System.out.println("Historial vacio");
        }

        for (int i = 0 ; i < History.conversionHistory.size() ; i++) {
            String conversionData = History.conversionHistory.get(i);
            String timeData = Time.dateHistory.get(i);

            System.out.println(
                timeData + "     " + conversionData
            );
        }
    }

}
