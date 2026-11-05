package arrays.store.modelo;

public class Juego {


    private String name;
    private String category;
    private int size;
    private double price;
    private int availableLicenses;
    private int soldLicenses;

    public Juego(String name, String category, int size, double price, int availableLicenses) {
        this.name = name;
        this.category = category;
        this.size = size;
        this.price = price;
        this.availableLicenses = availableLicenses;
        this.soldLicenses=0;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableLicenses() {
        return availableLicenses;
    }

    public int getSoldLicenses() {
        return soldLicenses;
    }



    public void setName(String name) {

        if (name!=null&&!name.trim().isEmpty())
            this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(int size) {
        if (size>0)
            this.size = size;
    }

    public void setPrice(double price) {
        if (price>0)
            this.price = price;
    }

    public boolean comprar(int cantidad){

        if (cantidad>0) {
            this.availableLicenses += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad){

        if (cantidad>0 && cantidad<=this.availableLicenses) {
            this.soldLicenses+=cantidad;
            this.availableLicenses-=cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", availableLicenses=" + availableLicenses +
                ", soldLicenses=" + soldLicenses +
                '}';
    }
}
