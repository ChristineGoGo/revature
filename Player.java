public class Player {
    public String playerName;
    public int level = 1;

    /**
     * this.playerName should be set to playerName.
     *
     * Constructor should assign the object's playerName using this.playerName to refer to the playerName at the top of
     * the class rather than the playerName in the parameter of this method (as they are both the exact same name).
     *      this.playerName = playerName;
     * The 'this' keyword specifies the left-hand playerName as the reference in 'this' class.
     *
     * We should also set the level value to 1 in this constructor as follows:
     *      this.level = 1;
     *
     * @param playerName the name of the player to be created.
     */
    public Player(String playerName){
        this.playerName = playerName;
    }

    /**
     * Again, the values of this object should be set with the help of the 'this' keyword to avoid confusion between
     * class fields / parameter variables.
     *
     * this.playerName should be set to playerName. this.level should be set to level.
     *
     * You may notice that this constructor has the same name as the first constructor. This is allowed, so long as
     * Java is able to differentiate between the constructors using different parameter types. This is referred to as
     * constructor overloading.
     *
     * @param playerName the name of the player to be created.
     * @param level the starting level of the player to be created.
     */
    public Player(String playerName, int level){
        this.playerName = playerName;
        this.level = level;
    }

}