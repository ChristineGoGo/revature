package application;
import java.sql.Connection;

import application.DAO.MessageDAO;
import application.Util.ConnectionUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection conn = ConnectionUtil.getConnection();
        MessageDAO messageDao = new MessageDAO();
        System.out.println(messageDao.getAllMessages());
    }
}
