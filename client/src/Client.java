import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class Client{
    public static void main(String[] args){
        try{
            Login loginObj = (Login) Naming.lookup("//localhost/Server/LoginObj");
            User user = loginObj.login(enterUserName(),enterPassword());
            System.out.println(user.getAdmin());


        }catch(Exception e){
            System.out.println("Clientside Error: " + e);
        }
    }

    public static String enterUserName() throws IOException {
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
