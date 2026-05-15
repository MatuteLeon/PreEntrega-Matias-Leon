package Utilities.Inputs;
import Model.Producto;
import java.util.Scanner;

import Utilities.InputsValidator.inputValidator;
public class inputProducto {
    private Scanner sc;
    private inputValidator validator;
    //Constructor
    public inputProducto(Scanner sc){
        this.sc = sc;
        this.validator = new inputValidator(sc);
    }
    
    //Metodos
    public Producto crearProducto(){
            Producto p = new Producto();
            p.setNombre(validator.leerProducto("Ingrese el nombre del producto, por favor"));
            p.setPrecio(validator.validarPrecio("Ingrese el precio"));
            p.setStock(validator.validarStock("Ingrese el stock actual"));
            return p;
    }

    public String productoBusqueda(){
        String p = validator.leerProducto("¿Que producto buscabas?");
        return p;
    }

    public Producto crearProducto(Producto p){
        if(p != null){
            do{
                if (validator.isUserConfirm("¿Desea cambiar el nombre del producto?")) {
                    p.setNombre(validator.leerProducto("Ingrese el nuevo nombre del productos"));
                }
                if (validator.isUserConfirm("¿Desea cambiar el precio del producto?")) {
                    p.setPrecio(validator.validarPrecio("Ingrese el nuevo precio"));
                }
                if(validator.isUserConfirm("¿Desea cambiar el stock actual?")){
                    p.setStock(validator.validarStock("Ingrese el nuevo stock"));
                }
                return p;
            }while(validator.isUserConfirm("Si los cambiamos fueron correctos, coloque si. \nSi no, coloque no"));
        }else{
            return null;
        }
        
    }


}
