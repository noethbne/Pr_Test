import java.rmi.RemoteException;
import java.util.ArrayList;

public class CourseImpl implements Course{
    int courseId, isPublic, ownerId, courseOwner;
    String courseDescription;
    String courseName;

    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    @Override
    public int getCourseId() throws RemoteException {
        return this.courseId;
    }
    public int getOwnerId() throws RemoteException{
        return this.ownerId;
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

    public CourseImpl(int newCourseId,int newIsPublic,int newCourseOwner,String newCourseName,String newCourseDesc){
        this.courseId = newCourseId;
        this.isPublic = newIsPublic;
        this.courseOwner = newCourseOwner;
        this.courseName = newCourseName;
        this.courseDescription = newCourseDesc;
    }
}
