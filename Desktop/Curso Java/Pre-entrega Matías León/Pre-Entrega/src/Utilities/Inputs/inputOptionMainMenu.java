package Utilities.Inputs;
import java.util.Scanner;
import java.util.InputMismatchException;

public class inputOptionMainMenu {
    private Scanner sc;

    public inputOptionMainMenu(Scanner sc){
        this.sc = sc;
    }

    public int optionMenu(){
        boolean isValid = false;
        int r;
        do{
            try {
                System.out.println("Por favor elija una opción: \n1.Agregar producto\n2.Mostrar Productos\n3.Buscar/Actualizar productos\n4.Eliminar Producto\n5.Crear pedido\n6.Listar Pedidos\n7.Salir");
                r = sc.nextInt();
                if(r < 1 || r > 7){
                    System.out.println("Opcion invalida, no existe en el menú");
                }else{
                    isValid = true;
                    break;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Opcion invalida, ingrese un numero");
                r = -1;
            }
        }while (!isValid);
        sc.nextLine();
        return r;
    }
}
