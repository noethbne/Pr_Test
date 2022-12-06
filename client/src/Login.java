import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Login extends Remote {
    public User login(String userName, String password) throws RemoteException;
}