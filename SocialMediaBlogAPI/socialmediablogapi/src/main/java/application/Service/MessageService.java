package application.Service;

import application.DAO.MessageDAO;
import application.Model.Message;

public class MessageService {
    MessageDAO messageDAO;

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
     * @param messageDAO
     * @return added message
     */
    public Message addMessageByUser(Message message) {
        Message newMessage = messageDAO.addMessage(message);
        
    }
    



    
}
