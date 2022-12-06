import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserImpl extends UnicastRemoteObject implements User{
    SQLDatabaseConnection dbConn;
    int userId;
    String userName;
    String password;
    int admin;
    int sessionId; //sessionId == seed :)

    HashMap<Integer, String> seeds = new HashMap<>();


    public int getUserId() throws RemoteException {
        return this.userId;
    }
    public String getUserName() throws RemoteException{
        return this.userName;
    }
    public String getPassword() throws RemoteException{
        return this.password;
    }
    public int getAdmin() throws RemoteException{
        return this.admin;
    }
    public int setUserName(String newUserName) throws RemoteException{
        this.userName = newUserName;
        return 0;
    }
    public int setPassword(String newPassword) throws RemoteException{
        this.password = newPassword;
        return 0;
    }

    public int getSessionId() throws RemoteException{
        return this.sessionId;
    }
    public ArrayList<Course> getCourses() throws RemoteException, SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        ResultSet rs = dbConn.getDBCourses();
        while (rs.next()){
            if(rs.getInt("deleted") == 1){
                continue;
            }
            int courseId = rs.getInt("courseId");
            int isPublic = rs.getInt("isPublic");
            int courseOwner = rs.getInt("userId");
            String courseName = rs.getString("name");
            String courseDesc = rs.getString("description");

            Course course = new CourseImpl(courseId, isPublic, courseOwner, courseName, courseDesc);
            courses.add(course);
        }
        return courses;
    }


    //Returns the Seed if successfull.
    private int generateSeed(String userName){
        int x;
        while (true) {
            x = (int) (Math.random() * 500000);
            if (!seeds.containsKey(x)) {
                seeds.put(x, userName);
                break;
            }
        }
        return x;
    }

    UserImpl(int newUserId, String newUserName, int newAdmin) throws RemoteException{
        dbConn = new SQLDatabaseConnection("","","");
        this.userId = newUserId;
        this.userName = newUserName;
        this.admin = newAdmin;
        this.sessionId = generateSeed(userName);
    }
}
