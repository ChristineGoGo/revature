package application.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.Model.Message;
import application.Service.MessageService;
import io.javalin.Javalin;
import io.javalin.http.Context;


public class MessageController {
    MessageService messageService;


    /** initialize the controller with the message Service */
    public MessageController() {
        messageService = new MessageService();
    }

    /**
     * Define the structure of the Javalin API using method
     */
    public Javalin startAPI () {
        Javalin app = Javalin.create();
        app.post("/messages", this::postMessageHandler);
        app.put("/messages/{message_id}", this::updateMessageHandler);
        app.get("/messages/", this::getMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByIdHandler);
        app.delete("messages/{message_id}", this::deleteMessageHandler);
        app.get("messages/user/{user_id}", this::getAllMessagesByUserHandler);

        return app;
    }

    /**
     * handler to add a new message
     * @param ctx
     * @throws  JsonProcessingException
     */
    private void postMessageHandler(Context ctx) throws  JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);
        Message addedMessage = messageService.addMessage(message);
        if (addedMessage == null) {
            ctx.status(400);
        } else {
            ctx.json(mapper.writeValueAsString(addedMessage));
        }
    }

    /**
     * handler to update an existing message using its message_id
     * @param ctx
     * @throws JsonProcessingException
     */
    private void updateMessageHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // Message message = mapper.readValue(ctx.body(), Message.class);
        // int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        // Message messageToUpdate = messageService.updateMessage(message_id, message);
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        String message_text = ctx.pathParam("message_text");
        Message messageToUpdate = messageService.updateMessage(message_id, message_text);

        if (messageToUpdate == null) {
            ctx.status(400);        
        } else {
            ctx.json(mapper.writeValueAsString(messageToUpdate));
        }
    }

    /**
     * handler to display all the messages
     * @param ctx
     */
    private void getMessagesHandler(Context ctx) {
        ctx.json(messageService.getMessages());
    }

    /**
     * handler to get message by message_id
     * @param ctx
     * @throws JSONProcessingException
     */
    private void getMessageByIdHandler(Context ctx) throws JsonProcessingException {
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));

        if (message_id > 0 ) {
            ctx.json(messageService.getMessagesById(message_id));
        } else {
            ctx.status(400);
        }
    }

    /**
     * handler to delete a message from the database
     * @param ctx 
     */
    private void deleteMessageHandler(Context ctx) {
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        if (message_id > 0) {
            messageService.deleteMessage(message_id);
        } else {
            ctx.status(400);
        }
    }

    /**
     * handler to display all the messages by a user
     * @param ctx
     * @throws JSONProcessingException
     */
    private void getAllMessagesByUserHandler(Context ctx) {
        int posted_by = Integer.parseInt(ctx.pathParam("posted_by"));
        ctx.json(messageService.getMessagesByUser(posted_by));
    }

}
