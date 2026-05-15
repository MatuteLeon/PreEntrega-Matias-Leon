package Controller;
import java.util.ArrayList;

import Service.ItemService.ItemService;
import Model.Producto;

public class MenuCarrito {
    

    public void mostrarListaCarrito(ArrayList<ItemService> carrito, double total){
        if(carrito.isEmpty()){
            System.out.println("Su carrito esta vacio, comprate algo, te lo mereces ;) ");
        }else{
            int i;
            System.out.println("\n----------LISTA DE COMPRA--------");
            System.out.printf("%-5s | %-20s | %-12s | %-8s%n", 
                       "PRODUCTO", "PRECIO UNID.", "Unidades", "SUBTOTAL");
            System.out.println("------------------------------------------------------------");
            for(i = 0; i < carrito.size(); i++){
                ItemService item = carrito.get(i);
                System.out.printf("%-15s | %-12.2f | %-10d | %-10.2f%n",
                            item.getNombre(),
                            item.getPrecio(),
                            item.getCant(),
                            item.getSubTotal()
                );   //ACA FINALIZA LAS COLUMNAS
            }
            System.out.println("------------------------------------------------");
            System.out.printf("%45s %-10.2f%n", "TOTAL A PAGAR: $", total);

        }
    }
}
