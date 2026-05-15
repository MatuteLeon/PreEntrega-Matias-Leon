package Controller;
import java.util.ArrayList;
import Model.Producto;

public class MenuProducts {
    
    public void mostrarListaProductos(ArrayList<Producto> productos){
        if (productos.isEmpty()) {
            System.out.println("No hay productos que mostrar");
            return;
        }else{
            int i;
            System.out.println("\n----------LISTA DE PRODUCTOS--------");
            System.out.printf("%-5s | %-20s | %-12s | %-8s%n", 
                      "ID", "PRODUCTO", "PRECIO", "STOCK");
            System.out.println("------------------------------------------------------------");
            for(i = 0; i < productos.size(); i++){
                Producto p = productos.get(i);
                System.out.printf("%-5d | %-20s | $%-9.2f | %-8d%n",
                            p.getId(),
                            p.getNombre(),
                            p.getPrecio(),
                            p.getStock()
                );   //ACA FINALIZA LAS COLUMNAS
            }
            System.out.println("------------------------------------------------");
        }
    }
}
