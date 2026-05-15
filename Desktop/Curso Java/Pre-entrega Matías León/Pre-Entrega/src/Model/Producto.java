package Model;
public class Producto {
    //Atributos
    private String nombre;
    private double precio;
    private int stock;
    private int id;
    private static int cantidadProductos;

    public Producto(){
        cantidadProductos++;
        this.id = cantidadProductos;
    }

    public int getId(){
        return this.id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setPrecio(double precio){
        if(precio > 0){
            this.precio = precio;
        }
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setStock(int stock){
        if(stock > -1){
            this.stock = stock;
        }
    }

    public int getStock(){
        return this.stock;
    }
}
