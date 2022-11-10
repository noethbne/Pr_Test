import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args){
        try{
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            ProductImpl testProduct = new ProductImpl("Test", "Desc Test", 123.5);

            Product stub = (Product) UnicastRemoteObject.exportObject(testProduct, 0);

            Registry registry = LocateRegistry.createRegistry(9100);

            registry.rebind("test", testProduct);

            System.out.println("Binding complete");

        }catch (Exception e){
            System.out.println("Server-Error: " + e);
        }
    }
}
