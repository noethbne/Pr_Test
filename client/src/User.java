import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
    public int getUserId() throws RemoteException;
    public String getUserName() throws RemoteException;

    public int setPassword() throws RemoteException;
    public int getAdmin() throws RemoteException;

}