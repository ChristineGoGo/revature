package application.Service;

import application.DAO.AccountDAO;
import application.Model.Account;

public class AccountService {
    AccountDAO accountDAO;


    /**
     * no-args constructor for a flightService that instantiates a plain accountDAO
     */
    public AccountService() {
        accountDAO = new AccountDAO();
    }

    /**
     * constructor for an accountService when a flightDAO is provided
     * this would allow for testing of AccountService independently of AccountDAO
     * @param accountDAO
     */
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    /** use accountDAO to add a user to the db
     * @param account
     * @return newly created account user
     */
    public Account addAccount(Account account) {
        Account newAccount = accountDAO.addAccount(account);
        Integer generatedAccountId = newAccount.getAccount_id();

        if (generatedAccountId > 1) {
            return newAccount;
        }
        return null;
    }
    
    /**
     * use accountDAO to verify a user/login
     * @param username
     * @param password
     * @param account
     * @return account
     */
    public Account getAccount(Account account, String username,String password) {
        Account matchedAccount = accountDAO.geAccount(username, password);
        if (matchedAccount.getAccount_id() > 0) {
            return matchedAccount;
        }
        return null;
    }

}
