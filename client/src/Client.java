import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class Client{
    public static void main(String[] args){
        try{
            User test = (User) Naming.lookup("//localhost/Server/User");
            test.setUser(enterUser());
            test.setPassword(enterPassword());
            System.out.println(test.getUser() + test.getPassword());
            test.testLogin();
        }catch(Exception e){
            System.out.println("Clientside Error: " + e);
        }
    }

    public static String enterUser() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Username:");
        return br.readLine();
    }
    public static String enterPassword() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter Password:");
        return br.readLine();
    }
}
