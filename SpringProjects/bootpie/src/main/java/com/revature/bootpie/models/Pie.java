package com.revature.bootpie.models;

public class Pie {
    private String pieName;
    private int calories;
    private int slicesAvailable;

    public Pie() {
    }

    public Pie(int calories, String pieName, int slicesAvailable) {
        this.calories = calories;
        this.pieName = pieName;
        this.slicesAvailable = slicesAvailable;
    }

    public String getPieName() {
        return pieName;
    }

    public void setPieName(String pieName) {
        this.pieName = pieName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getSlicesAvailable() {
        return slicesAvailable;
    }

    public void setSlicesAvailable(int slicesAvailable) {
        this.slicesAvailable = slicesAvailable;
    }



}
