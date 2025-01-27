package application.Controller;


import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.Model.Account;
import application.Model.Message;
import application.Service.AccountService;
import application.Service.MessageService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class SocialMediaController {
    /**
     * used to access the database through the messageService
     */

    MessageService messageService;
    /**
     * used to access the database through the accountService
     */
   AccountService accountService;


    /** initialize the controller with the messageService and accountService */
    public SocialMediaController() {
        messageService = new MessageService();
        accountService = new AccountService();
    }

    /**
     * Define the structure of the Javalin API using method
     */
    public Javalin startAPI () {
        Javalin app = Javalin.create();
        app.post("/messages", this::postMessageHandler);
        app.patch("/messages/{message_id}", this::updateMessageHandler);
        app.get("/messages/", this::getMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByIdHandler);
        app.delete("messages/{message_id}", this::deleteMessageHandler);
        app.get("/accounts/{account_id}", this::getAllMessagesByUserHandler);
        app.post("/register", this::addUserHandler);
        app.post("/login", this::loginHandler);

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
        
        if (!(addedMessage == null)) {
            ctx.json(mapper.writeValueAsString(addedMessage));
        } else {
            ctx.status(400);
        }
            
    }

    /**
     * handler to update an existing message using its message_id
     * @param ctx
     * @throws JsonProcessingException
     */
    private void updateMessageHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(ctx.body(), Message.class);
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        String message_text = message.getMessage_text();
        Message messageToUpdate = messageService.updateMessage(message_id, message_text);

        if ((messageToUpdate == null) || (message_id == 0)) {
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
        Message message = messageService.getMessagesById(message_id);

        if (message == null) {
            ctx.status(200);
        } else {
            // ctx.json(messageService.getMessagesById(message_id));
            ctx.json(message);
            ctx.status(200);

        }
    }

    /**
     * handler to delete a message from the database
     * @param ctx 
     */
    private void deleteMessageHandler(Context ctx) {
        int message_id = Integer.parseInt(ctx.pathParam("message_id"));
        Message deletedMessage = messageService.deleteMessage(message_id);

        if (deletedMessage == null) {
            ctx.status(200);
        } else {
            ctx.json(deletedMessage);
        }
    }

    /**
     * handler to display all the messages by a user
     * @param ctx
     * @throws JSONProcessingException
     */
    private void getAllMessagesByUserHandler(Context ctx) {
        int posted_by = Integer.parseInt(ctx.pathParam("account_id"));
        List <Message> messages = messageService.getMessagesByUser(posted_by);
        // System.out.println("The messages are: " + messages);

        if (!(messages == null)) {
            ctx.json(messages);
        }
        ctx.status(200);
        
    }


    /**
     * handler to verify user in db and facilitate login
     * @param ctx
     * @throws JsonProcessingException
     */
    private void loginHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        // String username = ctx.pathParam("username");
        // String password = ctx.pathParam("password");
        // System.out.println("account generated username is: " + account.getUsername());
        Account userAccount = accountService.getAccount(account.getUsername(), account.getPassword());
        int account_id = userAccount == null ? 0 : userAccount.getAccount_id();

        if (account_id > 0) {
            ctx.status(200);
            ctx.json(mapper.writeValueAsString(userAccount));
        } else {
            ctx.status(401);
        }

    }


    /**
     * handler to add a new user to the database
     * @param  ctx
     * @throws JsonProcessingException
     * 
     */
    private void addUserHandler(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Account account = mapper.readValue(ctx.body(), Account.class);
        Account addedAccount = accountService.addAccount(account);

        if (addedAccount == null) {
            ctx.status(400);
        } else {
            ctx.status(200);
            ctx.json(mapper.writeValueAsString(addedAccount));
        }
    }


}
