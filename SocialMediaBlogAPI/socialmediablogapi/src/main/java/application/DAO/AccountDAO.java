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
    public List<Account> getAccounts() {
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

}
