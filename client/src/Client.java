import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            Product test = (Product) registry.lookup("product");

            System.out.println(test.getName());
            System.out.println(test.getDescription());
            System.out.println(test.getPrice());


        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }
}