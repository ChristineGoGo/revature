package application.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.Model.Account;
import application.Service.AccountService;
import io.javalin.Javalin;
import io.javalin.http.Context;


public class AccountController {
    /**
     * used to access the database through the accountService
     */
    AccountService accountService;

    /**
     * Initialize the controller using the accountService
     * 
     */
    public AccountController() {
        accountService = new AccountService();
    }

    /**
     * Define the structure of the Javalin API using methods
     */
    public Javalin startApi() {
        Javalin app = Javalin.create();
        app.post("/register", this::addUserHandler);
        app.get("/login", this::loginHandler)
        return app;
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

    /**
     * handler to verify user in db and facilitate login
     * @param ctx
     * @throws JsonProcessingException
     */
    private void loginHandler(Context ctx) throws JsonProcessingException {
        String username = ctx.pathParam("username");
        String password = ctx.pathParam("password");
        

    }



}
