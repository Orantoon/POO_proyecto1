package app;


import java.io.IOException;

public class App {

    public static void main (String[] args) throws IOException {
        Window pantalla = new Window();
        Player jugador = new Player();
        Store tienda = new Store();

        pantalla.setVisible(true);

        System.out.println("Dinero Inicial: "+jugador.money);
        System.out.println("Inventario Inicial");
        for (int i = 0; i < 20; i++){
            System.out.println(jugador.inventory[i]);
            }
        System.out.println("Objetos en tienda Inicial");
        for (int i = 0; i < 20; i++){
            System.out.println(tienda.inventario[i]);
            }

        tienda.buyItem(jugador, 2);

        System.out.println("Dinero Final: "+jugador.money);
        System.out.println("Inventario Final");
        for (int i = 0; i < 20; i++){
            System.out.println(jugador.inventory[i]);
            }
        System.out.println("Objetos en tienda Final");
        for (int i = 0; i < 20; i++){
            System.out.println(tienda.inventario[i]);
            }

        tienda.sellItem(jugador, 2);

        System.out.println("Dinero ReFinal: "+jugador.money);
        System.out.println("Inventario ReFinal");
        for (int i = 0; i < 20; i++){
            System.out.println(jugador.inventory[i]);
            }
        System.out.println("Objetos en tienda ReFinal");
        for (int i = 0; i < 20; i++){
            System.out.println(tienda.inventario[i]);
            }
        }
    /*
    public static void btnComprar_Click() {
        if (tienda.objeto_seleccionado) {
            jugador.items.agregar(tienda.objeto_seleccionado);
            tienda.eliminar(tienda.objeto_seleccionado);
            print("felicidades por su compra");
            pantalla.cantidad = pantalla.cantidad - 1;
        } else {
            print("no hay objetos seleccionados para comprar");
        }
     } */
}
