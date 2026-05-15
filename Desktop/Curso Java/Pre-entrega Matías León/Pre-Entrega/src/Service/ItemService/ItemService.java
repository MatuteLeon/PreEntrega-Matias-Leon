//LA IDEA DE ESTA CLASE ES QUE CONECTE ENTRE EL STOCK Y EL CARRITO
//Asegurando copiar el producto del stock para pasarselo al carrito y evitar problemas de punteros y referencias.
package Service.ItemService;
import Model.Producto;
public class ItemService {
    private Producto itemCompra;
    private int cant;
    private double precio;

    public ItemService(Producto item){
        this.itemCompra = item;
        this.cant = 0;
        this.precio = item.getPrecio();
    }

    public boolean verificarStock(int unid){
        if(itemCompra.getStock() >= unid){
            return true;
        }
        return false;
    }

    public int getCant(){
        return this.cant;
    }
    public void setCantidad(int u){
        this.cant = u;
    }

    public String getNombre(){
        return this.itemCompra.getNombre();
    }

    public double getPrecio(){
        return this.itemCompra.getPrecio();
    }

    public double getSubTotal(){
        return this.precio * this.cant;
    }
}
