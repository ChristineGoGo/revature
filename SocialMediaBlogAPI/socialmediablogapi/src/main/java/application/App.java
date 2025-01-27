package application;
import application.Controller.SocialMediaController;
import io.javalin.Javalin;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Account account = new Account("test1", "password123");
        // AccountDAO acct = new AccountDAO();

        // System.out.println(acct.addAccount(account));
        SocialMediaController sc = new SocialMediaController();
        Javalin app = sc.startAPI();
        app.start(6000);
        
    }
}
