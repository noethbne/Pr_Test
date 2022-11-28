import java.rmi.RemoteException;
import java.util.ArrayList;

public class CourseImpl implements Course{
    int courseId;
    String courseDescription;
    String courseName;
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    @Override
    public int getCourseId() throws RemoteException {
        return this.courseId;
    }

    @Override
    public String getCourseDescription() throws RemoteException {
        return this.courseDescription;
    }

    @Override
    public String getCourseName() throws RemoteException {
        return this.courseName;
    }

    @Override
    public ArrayList<Exercise> getCourseExercise() throws RemoteException {
        return exercises;
    }
}
