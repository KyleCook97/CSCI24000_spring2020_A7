//Account.java

abstract class Account
{
    protected double balance;

    Account()
    {

    }//end constructor

    Account(double B)
    {
        balance = B;
    }//end overloaded constructor

    void withdraw(double amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
            System.out.println("You deposited $" + amount + " into your account");
        }
        else 
            System.out.println("You are attempting to withdraw more than your current balance.");
    }//end withdraw

    void deposit(double amount)
    {
        balance += amount;
    }//end deposit

    double getBalance()
    {
        return balance;
    }//end getBalance

}//end class def