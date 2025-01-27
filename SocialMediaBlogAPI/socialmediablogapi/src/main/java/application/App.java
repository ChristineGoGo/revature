package application;

import application.Controller.SocialMediaController;
import io.javalin.Javalin;

// import application.DAO.MessageDAO;
// import application.DAO.AccountDAO;

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
        // MessageDAO messageDAO = new MessageDAO();
        // Message message = new Message(2, "Hello daughter!", 9000922);
        // System.out.println(messageDAO.addMessage(message));
        // System.out.println(messageDAO.getAllMessages());
        // System.out.println(messageDAO.getMessageByUser(1));
        // System.out.println(messageDAO.updateMessageById(11, "Hello kind gentlewoman"));

        // ---------------------------------------------------------------------------
        SocialMediaController sc = new SocialMediaController();
        Javalin app = sc.startAPI();
        app.start(6000);
        
    }
}
