package App;
import Model.Producto;
import Service.OrderService.OrderService;
import Service.ProductService.ProductService;
import Utilities.Inputs.inputOptionMainMenu;
import Utilities.Inputs.inputProducto;

import java.util.Scanner;

import Controller.MainMenu;
import Controller.MenuProducts;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        OrderService carrito = new OrderService();
        ProductService productServ = new ProductService();
        inputProducto inputP = new inputProducto(sc);
        MenuProducts menuProd = new MenuProducts();
        MainMenu mainMenu = new MainMenu(sc, productServ,carrito); 
        inputOptionMainMenu optionMainMenu = new inputOptionMainMenu(sc);
        mainMenu.MostrarMenu();
        int option = 0;
        while(option !=7) {
            option = optionMainMenu.optionMenu();
            mainMenu.showOptionSelection(option);

        }
    }
}
