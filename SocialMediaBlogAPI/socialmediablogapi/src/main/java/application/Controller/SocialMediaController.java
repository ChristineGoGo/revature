package application.Controller;


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
        app.put("/messages/{message_id}", this::updateMessageHandler);
        app.get("/messages/", this::getMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByIdHandler);
        app.delete("messages/{message_id}", this::deleteMessageHandler);
        app.get("messages/user/{user_id}", this::getAllMessagesByUserHandler);
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
        int account_id = message.getPosted_by();
        Account account = accountService.getAccountById(account_id);

        if (!(account == null)) {
            Message addedMessage = messageService.addMessage(message);
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
        Message messageToUpdate = messageService.updateMessage(message_id, message);

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
