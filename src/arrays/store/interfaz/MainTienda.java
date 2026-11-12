package arrays.store.interfaz;

import arrays.store.modelo.Appstore;
import arrays.store.modelo.Juego;
import arrays.store.modelo.Validaciones;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc= new Scanner(System.in);
    private static Appstore tienda = new Appstore();
    private static Validaciones valid = new Validaciones();

    static void main(String[] args) {
        int opt = 0;
        tienda.inicializarData();
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
                    comprar();
                }break;
                case 5:{
                    vender();
                }break;
                case 6:{
                    juegoMasVendido();
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
        String nombre = valid.ValidarText("Ingresa el nombre, no puede ser nulo ni blanco");
        String categoria = valid.ValidarText("Ingresa la categoria, no puede ser nulo ni blanco");
        int tamanio = valid.ValidarEnteroYnonegativo("Ingrese el tamano");
        double precio = valid.ValidarDoubleNoNegativo("Ingresa el precio: ");
        int licenciasDisponibles = valid.ValidarEnteroYnonegativo("Ingrese las licencias disponibles: ");
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
    public static void comprar(){
        System.out.println("Que juego deseas comprar?");
        String nombre = sc.nextLine();

        int cantidad = valid.ValidarEnteroYnonegativo("Ingrese la cantidad que desea comprar: ");

        if (tienda.comprar(nombre, cantidad)){
            JOptionPane.showMessageDialog(null, "Compra realizada con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No fue posible realizar la compra");
        }
    }

    public static void vender(){
        System.out.println("Que juego deseas vender?");
        String nombre = sc.nextLine();

        int cantidad = valid.ValidarEnteroYnonegativo("Ingrese la cantidad que desea vender: ");

        if (tienda.vender(nombre, cantidad) > 0){
            JOptionPane.showMessageDialog(null, "Venta realizada con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No fue posible realizar la venta");
        }
    }

    public static void juegoMasVendido(){
        String juego = tienda.Mostselled();

        if (juego != null){
            System.out.println("*******Juego mas vendido*******");
            System.out.println(juego);
        }else{
            System.out.println("No hay juegos vendidos");
        }
    }

    }
