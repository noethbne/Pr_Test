import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
    public int getUserId() throws RemoteException;
    public String getUser() throws RemoteException;
    public String getPassword() throws RemoteException;
    public String getRoll() throws RemoteException;
    public void setUser(String newUsername) throws RemoteException;
    public void setPassword(String newPassword) throws RemoteException;

    public void testLogin() throws RemoteException;
}
