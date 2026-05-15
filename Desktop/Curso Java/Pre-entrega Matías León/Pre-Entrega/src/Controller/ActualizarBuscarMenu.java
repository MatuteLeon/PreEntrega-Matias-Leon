package Controller;
import java.util.Scanner;

import Utilities.InputsValidator.inputValidator;
import Utilities.Inputs.inputProducto;
import Service.ProductService.ProductService;
import Utilities.InputsValidator.inputValidator;
import Utilities.Inputs.inputProducto;
import Model.Producto;
public class ActualizarBuscarMenu {
    
    public Scanner sc;
    public ProductService productService;
    public inputValidator validation;
    public inputProducto inputP;

    //CONSTRUCTOR
    public ActualizarBuscarMenu(Scanner sc, ProductService service, inputProducto inputProd){
        this.sc = sc;
        this.inputP = inputProd;
        this.productService = service;
        this.validation = new inputValidator(sc);
    }

    public void optionSelection(){
        int option = validation.optionSubMenu("Por favor elija una opcion:\n1.Buscar producto\n2.Actualizar producto\n3.Volver al menu principal");
        switch (option) {
            case 1:
                do {
                    Producto p = productService.buscarProducto(validation.leerProducto("Ingrese el nombre del producto"));
                    if(p != null){
                        System.out.println("Producto encontrado, aca estan los detalles:");
                        System.out.println("\n============================================================");
                        System.out.printf("%-5s | %-20s | %-12s | %-8s%n", 
                                    "ID", "PRODUCTO", "PRECIO", "STOCK");
                        System.out.println("------------------------------------------------------------");
                        System.out.printf("%-5d | %-20s | $%-9.2f | %-8d%n",
                            p.getId(),
                            p.getNombre(),
                            p.getPrecio(),
                            p.getStock()
                        ); 
                    }else{
                        System.out.println("El producto no existe en la lista actualmente");
                }
                } while (validation.isUserConfirm("¿Desea buscar otro producto?"));
                break;
            case 2:
                System.out.println("Actualizar producto");
                do {
                    Producto p = productService.actualizarProducto(validation.validarStock("Ingrese el ID por favor"));
                    if (p != null){
                        p = inputP.crearProducto(p);
                    }
                } while (validation.isUserConfirm("¿Desea actualizar otro producto?"));
                break;
            case 3:
                break;
        }
    }

    
}
