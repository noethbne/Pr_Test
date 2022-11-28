import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserImpl extends UnicastRemoteObject implements User{
    int userId;
    String user;
    String password;
    String roll;


    public int getUserId() throws RemoteException {
        return this.userId;
    }
    public String getUser() throws RemoteException{
        return this.user;
    }
    public String getPassword() throws RemoteException{
        return this.password;
    }
    public String getRoll() throws RemoteException{
        return this.roll;
    }
    public void setUser(String newUser) throws RemoteException{
        this.user = newUser;
    }
    public void setPassword(String newPassword) throws RemoteException{
        this.password = newPassword;
    }

    public void testLogin() throws RemoteException{
        System.out.println("Test");
        SQLDatabaseConnection.login(getUser(), getPassword());
    }
    UserImpl(int newUserId, String newUser, String newPassword,String newRoll) throws RemoteException{
        this.userId = newUserId;
        this.user = newUser;
        this.password = newPassword;
        this.roll = newRoll;
    }
    UserImpl(String newUser, String newPassword) throws RemoteException{
        this.user = newUser;
        this.password = newPassword;
    }
}
