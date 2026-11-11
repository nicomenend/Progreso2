package arrays.store.modelo;

import java.util.Scanner;

public class Validaciones {
    private static Scanner sc = new Scanner(System.in);

    public static String ValidarText(String message){
        String word;
        do {
            System.out.println(message);
            word = sc.nextLine();
        }while(word == null || word.trim().isEmpty());
        return word;
    }

    public static int ValidarEnteroYnonegativo(String message){
        int number = 0;
        boolean ente = false;

        do {
            System.out.println(message);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number >= 0){
                    ente = true;
                }else {
                    System.out.println("Tiene que ser un numero positivo");
                }

            } catch (NumberFormatException e){
                System.out.println("Error, debes ingresar un numero entero");
            }

        }while(!ente );
        return number;
    }
    public static double ValidarDoubleNoNegativo(String message){
        double number = 0;
        boolean valid = false;
        do {
            System.out.println(message);
            try {
                number = Double.parseDouble(sc.nextLine());
                if (number >= 0){
                    valid = true;
                }else{
                    System.out.println("No puede ser un numero negativo");
                }
            } catch (NumberFormatException e){
                System.out.println("Debes ingresar un decimal");
            }
        }while(!valid);
        return number;
    }
}
