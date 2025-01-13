package com.revature;
import io.javalin.Javalin;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Javalin app = Javalin.create().start(9000);
        app.get("/hello", ctx -> ctx.result("Hello World"));
    }
}
