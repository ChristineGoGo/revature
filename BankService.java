public class BankService {
    double balance;

    public BankService() {
        this.balance = 0;
    }

    public void getBalance() 
    {
        System.out.println("Here goes the balance " + this.balance);
        // return balance; 
    }

    public void deposit(double amount) 
    {
        if (amount > 0)
            this.balance += amount;
    }

    public void withdraw(double amount) 
    {
        if (this.balance >=  amount){
            System.out.println("Here is your withdrawal");
            balance -= amount;
        }
        else {
            System.out.println("You have insufficient funds");
        }
            
    }
    
}
