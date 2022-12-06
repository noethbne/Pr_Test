import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginImpl extends UnicastRemoteObject implements Login {
    @Override
    public User login(String userName, String password) throws RemoteException {
        SQLDatabaseConnection dbConn = new SQLDatabaseConnection("","","");
        if(dbConn.login(userName, password)){
            int userId = dbConn.getUserId(userName);
            int isAdmin = dbConn.isAdmin(userName);
            return new UserImpl(userId, userName, isAdmin);
        }
        throw new RemoteException("Login failed");
    }
    public LoginImpl() throws RemoteException{}
}
