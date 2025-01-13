import java.util.Scanner;

public class BankMenu 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean banking = true;
        BankService forPerson = new BankService();

        while (banking) {
            System.out.println("Welcome to the bank! Press 1 to make a deposit. Press" 
            + "2 to make a withdrawal, 3 to view balance and 4 to exit this menu.");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("How much would you like to deposit?");
                double amount = sc.nextDouble();
                forPerson.deposit(amount);
            }
            else if (option == 2){
                System.out.println("How much would you like to withdraw?");
                double amount = sc.nextDouble();
                forPerson.withdraw(amount);
            }
            else if (option == 3) {
                forPerson.getBalance();
            }
            else if (option == 4) {
                System.out.println("Exiting the menu now!");
                banking = false;
            }
        }
    }
}

