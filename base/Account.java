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
        balance -= amount;
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