package Service.OrderService;
import Model.Producto;
import java.util.ArrayList;

import Service.ItemService.ItemService;

public class OrderService {
    //Parametros
    private ArrayList<ItemService> carrito;
    private int idOrden;
    private int cantidadOrdenes;
    private double total;

    //Constructos
    public OrderService(){
        this.idOrden = ++cantidadOrdenes; //Cada orden tendra su ID propio que sera igual a la cantidad de ordenes vendidas;
        this.total = 0; //Monto total a pagar
        this.carrito = new ArrayList<>();
    }

    public void agregarProductoCarrito(ItemService item){
        this.carrito.add(item);
    }

    public ArrayList<ItemService> mostrarCarrito(){
        return carrito;
    }

    public double calcularTotal(){
        int i;
        for(i = 0; i < carrito.size(); i++){
            this.total += carrito.get(i).getSubTotal();
        }
        return this.total;
    }

    public int getIdCompra(){
        return this.idOrden;
    }


}
