/*
 * Max Barrett, Jack Baretz, and Owen Reilly
 * CS-280
 * Project 1
 * 02/27/2024
 *
 * TODO : Make subclasses for each type of account (checking, savings, whatever else). (this is polymorphism)
 */


public class BankSystemTest
{
    public static void main(String[] args) throws InsufficientFundsException {
        Bank bank = new Bank();
        bank.name = "Bank of America";

        Customer customer = new Customer();
        customer.name = "Max Barrett";
        customer.address = "1234 Main St";
        customer.email = "something@balls.com";
        customer.phone = "123-456-7890";
    

        bank.addCustomer(customer);

        customer.createAccount("Checking", 1000);
        customer.createAccount("Savings", 1000);

        Account account1 = customer.accounts.get(0);
        Account account2 = customer.accounts.get(1);

        account1.deposit(100);
        System.out.println("Account 1 balance: " + account1.balance);

        account2.withdraw(50);
        System.out.println("Account 2 balance: " + account2.balance);
        
        // testing transfer system. should transfer 1000 dollars from account 1 to account 2
        account1.transferOut(account2, 1000);

        System.out.println("Account 1 transactions: " + account1.transactions);
        System.out.println("Account 1 balance:  " + account1.balance);



        account1.viewTransactions();

        System.out.println("Customer has " + customer.accounts.size() + " accounts");
        System.out.println("Bank has " + bank.customers.size() + " customers");

        customer.removeAccount(account1);
        System.out.println("Customer has " + customer.accounts.size() + " accounts");

        bank.removeCustomer(customer);
        System.out.println("Bank has " + bank.customers.size() + " customers");


    }


}



