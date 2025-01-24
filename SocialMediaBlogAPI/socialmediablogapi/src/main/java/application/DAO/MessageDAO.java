package application.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Model.Message;
import application.Util.ConnectionUtil;


public class MessageDAO {
    /**
     * retrieve all messages from the message table
     * @return all messages
     */
    public List<Message> getAllMessages() {
        Connection conn = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();

        try {
            String sql = "SELECT * FROM message;";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                Message message = new Message();
                message.setMessage_id(result.getInt("message_id"));
                message.setPosted_by(result.getInt("posted_by"));
                message.setMessage_text(result.getString("message_text"));
                message.setTime_posted_epoch(result.getInt("time_posted_epoch"));

                messages.add(message);
            }

            return messages;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
