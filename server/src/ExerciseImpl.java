import java.rmi.RemoteException;

public class ExerciseImpl implements Exercise{
    String exerciseDescription;
    String exerciseName;
    int exerciseId;

    @Override
    public int getExerciseId() throws RemoteException {
        return exerciseId;
    }

    @Override
    public String getExerciseDescription() throws RemoteException {
        return exerciseDescription;
    }

    @Override
    public String getExerciseName() throws RemoteException {
        return exerciseName;
    }
    ExerciseImpl(int id, String desc, String name){
        this.exerciseId = id;
        this.exerciseDescription = desc;
        this.exerciseName = name;
    }
}
