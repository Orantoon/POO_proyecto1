package app;


public class App {
    
    public static void main(String[] args) {
        Window pantalla = new Window();
        Player jugador = new Player();
        Store tienda = new Store();

        pantalla.setVisible(true);

        System.out.println("Inventario Inicial");
        for (int i = 0; i < 20; i++){
            System.out.println(jugador.inventory[i]);
        }
        System.out.println("Dinero Inicial");
        System.out.println(jugador.money);
        System.out.println("Stats Inicial");
        for (int i = 0; i < 5; i++){
            System.out.println(jugador.stats[i]);
        }

        tienda.buyItem();

        System.out.println("Inventario Final");
        for (int i = 0; i < 20; i++){
            System.out.println(jugador.inventory[i]);
        }
        System.out.println("Dinero Final");
        System.out.println(jugador.money);
        System.out.println("Stats Final");
        for (int i = 0; i < 5; i++){
            System.out.println(jugador.stats[i]);
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
