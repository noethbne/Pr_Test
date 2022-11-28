import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Course extends Remote {
    public int getCourseId() throws RemoteException;
    public String getCourseDescription() throws RemoteException;
    public String getCourseName() throws RemoteException;
    public Course getCourseExercise() throws RemoteException;
}