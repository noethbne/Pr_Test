import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject{
    String user, password, roll;
    int userId;

    protected Server() throws RemoteException {
        super(0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Server started");

        try{
            LocateRegistry.createRegistry(1099);
            System.out.println("Java rmi registry created");
        }catch (RemoteException e){
            System.out.println("RMI registry already exists");
        }

        Server server = new Server();
        User test = new UserImpl("Herbet", "");

        Naming.rebind("//localhost/Server", server);
        Naming.rebind("//localhost/Server/User", test);
        System.out.println("Server bound in registry");

    }
}

