import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exercise extends Remote {
    public int getExerciseId() throws RemoteException;
    public String getExerciseDescription() throws RemoteException;
    public String getExerciseName() throws RemoteException;
}