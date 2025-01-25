package application.Service;

import java.util.List;

import application.DAO.AccountDAO;
import application.DAO.MessageDAO;
import application.Model.Account;
import application.Model.Message;

public class MessageService {
    /**
     * for the MessageDAO to map to the message table
     */
    MessageDAO messageDAO;
    /**
     * for the AccountDAO to map to the account table
     */
    AccountDAO accountDAO;
    /**
     * no-args constructor that instantiates a plain messageDAO;
     */
    public MessageService() {
        messageDAO = new MessageDAO();
    }
    /**
     * constructor for messageService when a messageDAO is provided
     * @param messageDAO;
     */
    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    /**
     * use the messageDAO to add a new message to the database
     * @param message
     * @return added message
     */
    public Message addMessage(Message message) {
        Message newMessage = messageDAO.addMessage(message);
        Integer generatedMessageId = newMessage.getMessage_id();
        if (generatedMessageId > 0) {
            return newMessage;
        }
        return null;
    }

    /**
     * use the messageDAO to update a message in the database
     * @param message_id
     * @return message
     */
    public Message updateMessage(int message_id, Message message) {
        Message messageToUpdate = messageDAO.getMessageById(message_id);
        if (!(messageToUpdate == null)) {
            messageDAO.updateMessageById(message_id, message);
        }
        return null;

    }
    
    /**
     * get all the messages in the message table
     * @return all available messages
     */
    public List<Message> getMessages() {
        return messageDAO.getAllMessages();
    }

    /**
     * get messages using the message_id
     * @param message_id
     * @return messages with the message_id
     */
    public Message getMessagesById(int message_id) {
        Message message = messageDAO.getMessageById(message_id);
        if (message.getMessage_id() > 0) {
            return message;
        }
        return null;
    }

    /**
     * get messages from a specific user
     * @param posted_by
     * @return list of messages from the user 
     */
    public List<Message> getMessagesByUser(int posted_by) {
        Account user = accountDAO.getAccountById(posted_by);
        if (user.getAccount_id() > 0) {
            return messageDAO.getMessageByUser(posted_by);
        }
        return null;
    }

    /**
     * delete a message from the message table
     * @param message_id
     */
    public void deleteMessage() {
        
    }


    
}
