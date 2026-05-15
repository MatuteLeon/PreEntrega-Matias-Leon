package Service.ProductService;
import java.util.ArrayList;

import Utilities.InputsValidator.inputValidator;
import Model.Producto;

public class ProductService {
    ArrayList<Producto> productos = new ArrayList<>(); 

    

    //Metodo para agregar
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    //Metodo para devolver
    public ArrayList<Producto> mostrarProductos(){
        return productos;
    }

    //Metodo de busqueda por nombre
    public Producto buscarProducto(String nombre){
        for (Producto p : productos) {
            if(p.getNombre().equalsIgnoreCase(nombre.trim())){
                return p;
            }
        }
        return null;
    }

    //Metodo de busqueda por ID
    public Producto buscarProducto(int ID){
        for (Producto p : productos) {
            if(p.getId() == ID){
                return p;
            }
        }
        return null;
    }


    //Metodo para actualizar un producto
    public Producto actualizarProducto (int ID){
        for (Producto p : productos) {
            if(p.getId() == ID){
                return p;
            }
        }
        return null;
    }

    //Metodo para eliminar un producto
    public boolean eliminarProducto(int ID){
        int i;
        for(i = 0; i < productos.size(); i++){
            if(productos.get(i).getId() == ID -1){
                return true;
            }
        }
        return false;
    }

    public void eliminarProducto(int ID, boolean confirmacion){
        productos.remove(ID -1);
    }
}
