import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Course extends Remote {
    public int getCourseId() throws RemoteException;
    public int getOwnerId() throws RemoteException;
    public String getCourseDescription() throws RemoteException;
    public String getCourseName() throws RemoteException;
    public ArrayList<Exercise> getCourseExercise() throws RemoteException;
}