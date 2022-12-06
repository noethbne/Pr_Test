import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface User extends Remote {
    public int getUserId() throws RemoteException;
    public String getUserName() throws RemoteException;
    public String getPassword() throws RemoteException;
    public int getAdmin() throws RemoteException;
    public int setUserName(String newUserName) throws RemoteException;
    public int setPassword(String newPassword) throws RemoteException;

    public ArrayList<Course> getCourses() throws RemoteException, SQLException;

}
