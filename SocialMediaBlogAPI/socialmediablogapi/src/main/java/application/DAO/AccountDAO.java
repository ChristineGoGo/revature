package application.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Model.Account;
import application.Util.ConnectionUtil;



public class AccountDAO {
    /**
     * get all the users(accounts)
     * @return list of all accounts
     */
    public List<Account> getAllAccounts() {
        Connection conn = ConnectionUtil.getConnection();
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM account;";

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();
            
            while (rst.next()) {
                Account account = new Account();
                account.setAccount_id(rst.getInt("account_id"));
                account.setUsername(rst.getString("username"));
                account.setPassword(rst.getString("password"));
                accounts.add(account);
            }
            return accounts;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * get account by the id
     * @param account_id
     * @return a user account
     */
    public Account getAccountById(int account_id) {
        Connection conn = ConnectionUtil.getConnection();
        Account account = new Account();

        try {
            String sql = "SELECT * FROM account WHERE account_id = ?;";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) { 
                account.setAccount_id(rst.getInt("account_id"));
                account.setUsername(rst.getString("username"));
                account.setPassword(rst.getString("password"));
            }
            return account;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * check if an account exists
     * @param account
     * @return account if exists otheriwse null
     */
    public Account checkAccount(Account account) {
        Connection conn = ConnectionUtil.getConnection();
        Account accountFound = new Account();
        int account_id = account.getAccount_id();

        try {
            String sql = "SELECT * FROM account WHERE account_id = ?;";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setInt(1, account_id);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                accountFound.setAccount_id(result.getInt("account_id"));
                accountFound.setUsername(result.getString("username"));
                accountFound.setPassword(result.getString("password"));
            }
            return accountFound;
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * create a new user account
     * account_id is autogenerated
     * password should have atleat 4 characters and username must be provided
     * the username should not exist already
     * @param username
     * @param password
     * @return newly created user
     */
    public Account addAccount(Account account) {
        String pass = account.getPassword();
        Account existingAccount = checkAccount(account);
        Account newAccount = new Account();

        if (pass.length() < 4) {
            System.out.println("enter valid password!");
            return null;
        }

        if (existingAccount == null) {
            Connection conn = ConnectionUtil.getConnection();

            try {
                String sql = "INSERT INTO account (username, password) VALUES (?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                
                pst.setString(1, account.getUsername());
                pst.setString(2, account.getPassword());

                pst.executeUpdate();

                ResultSet pKeyGenerated = pst.getGeneratedKeys();
                if (pKeyGenerated.next()) {
                    int generated_account_id = (int) pKeyGenerated.getLong(1);
                    newAccount.setAccount_id(generated_account_id);
                    newAccount.setUsername(account.getUsername());
                    newAccount.setPassword(account.getPassword());
                    return newAccount;
                }
    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Account exists!");
        }
        
        return null;
    }

}
