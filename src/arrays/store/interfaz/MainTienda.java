package arrays.store.interfaz;

import arrays.store.modelo.Appstore;
import arrays.store.modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc= new Scanner(System.in);
    private static Appstore tienda = new Appstore();

    static void main(String[] args) {
        int opt = 0;
        do {
            menu();
            opt = Integer.parseInt(sc.nextLine());
            switch (opt){
                case 1:{
                    IngresarJuego();
                }break;
                case 2:{
                    printgames();
                }break;
                case 3:{
                    search();
                }break;
                case 4:{

                }break;
                case 5:{

                }break;
                case 6:{

                }break;


            }
        }while (opt !=7);

        }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");

    }

    public static void IngresarJuego(){
        System.out.println("*******Ingreso de datos********");
        String nombre = ValidarTexto("Ingresa el nombre, no puede ser nulo ni blanco");
        String categoria = ValidarTexto("Ingresa la categoria, no puede ser nulo ni blanco");
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if (tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "Juego INgresado con exito");

        }else{
            JOptionPane.showMessageDialog(null, "No fue posible agregar el juego");
        }
    }

    public static void printgames(){
        Juego juego[] = tienda.getJuegos();
        for (Juego j: juego){
            if (j != null){
                System.out.println(j);
            }
            else {
                System.out.println("No more games");
                return;
            }
        }
    }

    public static void search(){
        System.out.println("Que juego quieres buscar? ");
        String name = sc.nextLine();
        Juego juegos[] = tienda.getJuegos();
        for (Juego j: juegos){
            if (j.getName().equalsIgnoreCase(name)) {
                System.out.println("Informacion del juego: "+j);
                return;
            }
            else{
                System.out.println("Juego no encontrado");
                return;
            }
        }

    }

    public static String ValidarTexto(String message){

        String word;
        do {
            System.out.println(message);
            word = sc.nextLine();
        }while (word == null || word.trim().isEmpty());
        return word;

    }

    public static int ValidarInt(String message){

        int number;
        do {
            System.out.println(message);
            number = sc.nextInt();
        }while (number || number.)
    }
    }


