import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            ProductImpl product = new ProductImpl("Name", "Beschreibung", 187);

            Product stub = (Product) UnicastRemoteObject.exportObject(product,0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            registry.bind("product", stub);
        }catch (Exception e){
            System.out.println("Error " + e);
        }
    }
}