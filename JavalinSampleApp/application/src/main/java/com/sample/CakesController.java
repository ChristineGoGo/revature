package com.sample;

import io.javalin.http.Context;

public final class CakesController {
    private CakesController(){}

    static String[] availableCakes = {"black forest cake", "chocolate cake", "carrot cake"};

    public static void getAllCakes(Context context) {
        context.json(availableCakes);
    }
    public static void getSpecialCake(Context context) {
        for (String cake: availableCakes) {
            if (cake.contains(context.pathParam("special"))) {
                context.result(cake);
                return;
            }
            
        }
        context.result("No cake found!)");
    }

}
