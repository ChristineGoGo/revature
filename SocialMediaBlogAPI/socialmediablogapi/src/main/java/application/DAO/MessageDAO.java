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

    /**
     * get message from database by the id of the message
     * @param message_id
     * @return Message from the message table with the given id 
     */
    public Message getMessageById(int message_id) {
        Connection conn = ConnectionUtil.getConnection();
        Message message = new Message();

        try {
            String sql = "SELECT * FROM message WHERE message_id = ?;";

            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, message_id);
            
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                message.setMessage_id(result.getInt("message_id"));
                message.setMessage_text(result.getString("message_text"));
                message.setPosted_by(result.getInt("posted_by"));
                message.setTime_posted_epoch(result.getLong("time_posted_epoch"));
            }
            return message;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * add a message to the message table
     * @param message object
     * @return newly returned message
     */
    public Message addMessage(Message message) {
        Connection conn = ConnectionUtil.getConnection();
        Message newMessage = new Message();

        try {
            String sql = "INSERT INTO message (posted_by, message_text, time_posted_epoch) VALUES (?, ?, ?);";

            PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setInt(1, message.getPosted_by());
            pst.setString(2, message.getMessage_text());
            pst.setLong(3, message.getTime_posted_epoch());

            pst.executeUpdate();

            ResultSet pKeyResultSet = pst.getGeneratedKeys();

            if (pKeyResultSet.next()) {
                int generated_message_id = (int) pKeyResultSet.getLong(1);
                newMessage.setMessage_id(generated_message_id);
                newMessage.setPosted_by(message.getPosted_by());
                newMessage.setMessage_text(message.getMessage_text());
                newMessage.setTime_posted_epoch(message.getTime_posted_epoch());
                return newMessage;
            }
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * update a message in the message table using the message id
     * @param message_id
     * @param message
     */
    public void updateMessageById(int message_id, Message message) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "UPDATE TABLE message SET posted_by = ?, message_text = ?, time_posted_epoch = ? WHERE message_id = message_id;";


            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, message.getPosted_by());
            pst.setString(2, message.getMessage_text());
            pst.setLong(3, message.getTime_posted_epoch());
            pst.setInt(4, message_id);

            pst.executeUpdate();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * delete a message from the message table by its id
     * @param message_id
     */
    public void deleteMessageById(int message_id) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "DELETE FROM message WHERE message_id = ?;";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, message_id);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * retrieve a message given the user id
     * @param posted_by
     * @return message
     */

    public List<Message> getMessageByUser(int posted_by) {
        Connection conn = ConnectionUtil.getConnection();
        List<Message> messages = new ArrayList<>();

        try {
            String sql = "SELECT * FROM message WHERE posted_by = ?;";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, posted_by);

            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                Message message = new Message();
                message.setMessage_id(rst.getInt("message_id"));
                message.setPosted_by(rst.getInt("posted_by"));
                message.setMessage_text(rst.getString("message_text"));
                message.setTime_posted_epoch(rst.getLong("time_posted_epoch"));
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
