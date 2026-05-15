package Utilities.InputsValidator;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class inputValidator {
    private Scanner sc;

public inputValidator (Scanner sc){
    this.sc = sc;
}

public double validarPrecio(String mensaje){
    while(true){
        try{
            System.out.println(mensaje);
            String parsear = sc.nextLine();
            Double precioOriginal = Double.parseDouble(parsear);
            BigDecimal bd = new BigDecimal(precioOriginal);
            bd = bd.setScale(2,RoundingMode.HALF_UP);
            Double precioFinal = bd.doubleValue();
            
            if(precioFinal < 0 || precioFinal == 0){
                System.out.println("Ingrese un precio mayor a 0");
            }else{
                return precioFinal;
            }
        }catch(NumberFormatException e){
            System.out.println("Debe ingresar un numero positivo (Si uso coma, use punto .)");
        }
    }
}

public int validarStock(String mensaje){
    while (true) {
        try {
            System.out.println(mensaje);
            String parsear = sc.nextLine();
            int stock = Integer.parseInt(parsear);
            if(stock < 0){
                System.out.println("El stock no puede ser menor 0");
            }else{
                return stock;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
        }
    }
}

public String leerProducto (String mensaje){
    while(true){
        System.out.println(mensaje);
        String producto = sc.nextLine().trim().toLowerCase();
        if(producto.isEmpty()){
            System.out.println("El nombre no puede estar vacio");
        }else{
            return producto;
        }
    }
}

public boolean isUserConfirm(String mensaje){
    while (true) {
        System.out.println(mensaje + " S/N.");
        String respuesta = sc.nextLine().trim().toLowerCase();
        if(respuesta.equals("s") || respuesta.equals("si")){
            return true;
        }else if(respuesta.equals("n")|| respuesta.equals("no")){
            return false;
        }else{
            System.out.println("Error: Ingrese 'SI' o 'S' para confirmar o 'No' o 'N' para negar" );
        }
    }
}

    public int optionSubMenu(String mensaje){
        int option;
        while (true) {
            try {
                System.out.println(mensaje);
                String parsear = sc.nextLine();
                option = Integer.parseInt(parsear);
                if(option < 0 || option > 4){
                    System.out.println("Opcion no valida");
                }else{
                    return option;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }
    }

}
