package Controller;
import java.util.Scanner;


import Model.Producto;
import Service.ItemService.ItemService;
import Service.OrderService.OrderService;
import Utilities.InputsValidator.inputValidator;
import Utilities.Inputs.inputProducto;
import Service.ItemService.ItemService;
import Service.OrderService.OrderService;
import Service.ProductService.ProductService;
public class MainMenu {
    private Scanner sc;
    private MenuProducts menuProduct;
    private ProductService productService ;
    private inputProducto inputProd;
    private inputValidator validator;
    private ActualizarBuscarMenu subMenu;
    private OrderService carrito;
    private MenuCarrito menuCarrito;

    public MainMenu(Scanner sca, ProductService services, OrderService carrito){
        this.sc = sca;
        this.carrito = carrito;
        this.menuCarrito = new MenuCarrito();
        this.menuProduct = new MenuProducts();
        this.productService = services;
        this.inputProd = new inputProducto(sc);
        this.validator = new inputValidator(sc);
        this.subMenu = new ActualizarBuscarMenu(sc, this.productService, inputProd);
    }

    public void MostrarMenu(){
        System.out.println("Bienvenido a ¡Mondongo's Shop!");
        
    }

    public void showOptionSelection (int o){
        switch (o) {
            case 1:
                do {
                    productService.agregarProducto(inputProd.crearProducto());
                    System.out.println("Producto guardado");
                } while (validator.isUserConfirm("¿Desea agregar otro producto?"));
                break;
            case 2:
                System.out.println("A continuación la lista de productos que tenemos actualmente: ");
                menuProduct.mostrarListaProductos(productService.mostrarProductos());
                break;
            case 3:
                subMenu.optionSelection();
                break;
                
            case 4:
                int id = validator.validarStock("Ingrese la ID por favor");
                boolean busqueda = productService.eliminarProducto(id);
                if (busqueda) {
                    boolean respuesta = validator.isUserConfirm("Se encontro el producto, \n ¿Esta seguro que desea eliminarlo?");
                    if (respuesta) {    
                        productService.eliminarProducto(id, respuesta);
                        System.out.println("Producto eliminado correctamente");
                    }else{
                        System.out.println("Eliminación cancelada.");
                    }
                }else{
                    System.out.println("Producto no encontrado, id erronea o no existe");
                }
                break;
            case 5:
                do {
                    Producto p = productService.buscarProducto(validator.leerProducto("Ingrese el nombre del producto"));
                    if(p == null){
                        System.out.println("Producto no encontrado");
                    }else{
                        ItemService item = new ItemService(p);
                        int unid = validator.validarStock("Ingrese cuantas unidades quieres");
                        while (!item.verificarStock(unid)) {
                            unid = validator.validarStock("Cantidad no disponible, ingrese un número más pequeño");
                        }
                        item.setCantidad(unid);
                        carrito.agregarProductoCarrito(item);
                    }
                } while (validator.isUserConfirm("¿Desea agregar algo más?"));
                break;
            case 6:
                menuCarrito.mostrarListaCarrito(carrito.mostrarCarrito(), carrito.calcularTotal());
                if(validator.isUserConfirm("Quiere confirmar la compra")){
                    System.out.println("Compra realizada con exito!");
                    System.out.println("Su orden de compra es : " + carrito.getIdCompra());
                    //Aca deberia modificarse el stock de la compra.
                }
                break;
            case 7:
                System.out.println("Muchas gracias por visitarnos!");;
                break;
        }
    }
}
