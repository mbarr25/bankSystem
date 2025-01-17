import java.util.ArrayList;

public class Account
{

    // ACCOUNT ATTRIBUTES
    int accountNumber;
    String accountType;
    double balance;
    ArrayList<Transaction> transactions = new ArrayList<>();


    // ACCOUNT METHODS
    void deposit(double amount)
    {
        balance += amount;
    }

    void withdraw(double amount)
    {
        balance -= amount;
    }

    void transferIn(Account fromAccount, double amount)
    {
        this.balance += amount;
        Transaction transaction = new Transaction(amount, fromAccount, "in");
        this.transactions.add(transaction);

    }

    void transferOut(Account toAccount, double amount) throws InsufficientFundsException{
        if (this.balance >= amount){
            // given account has enough money
            //1. make new transaction type Transfer Out
            Transaction transaction = new Transaction(amount, toAccount, "out");
            //2. add dat bih to the (account making the transfer)'s list
            this.transactions.add(transaction);
            //3. call the transferIn method of the account we are sending the money to
            // the fromAccount argument will be account sending money (this)
            toAccount.transferIn(this, amount);
            this.balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Insufficient funds for transfer: required " + amount + ", available " + this.balance);
        }
    }

    void purchase(double amount, String purchaseBusiness) throws InsufficientFundsException
    {
        if (this.balance >= amount){
            Transaction transaction = new Transaction(amount, purchaseBusiness);
            this.transactions.add(transaction);
            this.balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Insufficient funds for purchase: required " + amount + ", available " + this.balance);
        }
    }



    void viewTransactions()
    {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.type);
        }
    }

}
