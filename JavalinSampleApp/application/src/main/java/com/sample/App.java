package com.sample;

import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(7070);

        app.get("/cakes", CakesController::getAllCakes);
        app.get("/cakes/{special}", CakesController::getSpecialCake);
    }
}
