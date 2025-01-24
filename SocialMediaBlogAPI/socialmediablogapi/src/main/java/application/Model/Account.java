package application.Model;

import java.util.Objects;

public class Account {

    public int account_id;
    public String username;
    public String password;

    /**
     * a default no args-constructor
     */
    public Account() {
    }
    /**
    * constructor without account_id since it is auto generated
    * this is for creating a new user 
    * @param username
    * @param password
    */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** constructor including the account_id
     * this is for retrieving a user from the database
     * @param account_id
     * @param username
     * @param password
     */

    public Account(int account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
    }

    /**
     * Getters and setters for the Account class
     * @return account_id
     */
    public int getAccount_id() {
        return account_id;
    }

    /**
     * @param account_id
     */
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    /**
     * @return username;
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *@param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Overriding the default equals adds functionality when
     * telling whether two objects are equal
     * @param obj the other object
     * @return true if o is equal to this object
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }
    /**
     * overriding the default toString method to display the Account
     * object in an appropriate manner
     * @return a String representation of this class
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account{");
        sb.append("username=").append(username);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }

}
