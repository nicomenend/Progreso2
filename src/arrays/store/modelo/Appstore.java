package arrays.store.modelo;

import javax.print.attribute.standard.PageRanges;

public class Appstore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;


    public Appstore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    // EL JAVA DA EL SET Y GET SIN LOS CORCHETES, LO CUAL DA ERROR
    public Juego[] getJuegos() {
        return juegos;
    }

    /* No se usa por que los datos se ingresan de uno en uno
    public void setJuegos(Juego juegos[]) {
        this.juegos = juegos;
    }*/

    public boolean agregarJuego(Juego j){
        if (j != null && indice < MAX-1){
            // PRE INCREMENTO ES ++
            juegos[++indice] = j;
            return true;
        }
        else{
            return false;
        }
    }
    public Juego search(String name){
        if (name != null && name.trim().isEmpty()){
            for (int i = 0; i <= indice ; i++) {
                // COmpara que sean iguales con el equals
                if (juegos[i].getName().equalsIgnoreCase(name)){
                    return juegos[i];

                }

            }
            return null;
        }
        return null;
    }

    public boolean comprar(String name, int quantity){
        Juego j = search(name);
        if (j != null){
            return j.comprar(quantity);
        }
        return false;
    }

    public double vender(String name, int quantity){
        Juego j = search(name);
        if (j != null){
            if (j.vender(quantity)){
                return j.getPrice() * quantity;
            }
            return 0;

        }
        return 0;
    }

    public void inicializarData(){
        agregarJuego(new Juego("LOL","ACCION", 20, 45,60));
        agregarJuego(new Juego("FIFA26","Deportes",10,67,50));
    }


    public String Mostselled(){
        String name = "";
        int mayor;
        if (indice>=0){
            name = juegos[0].getName();
            mayor = juegos[0].getSoldLicenses();
            for (Juego j: juegos){
                if (j != null) {
                    if (j.getSoldLicenses()> mayor){
                        mayor = j.getSoldLicenses();
                        name= j.getName();
                    }
                }
                else {
                    return name;
                }
            }
        }
        return name;
    }
}
