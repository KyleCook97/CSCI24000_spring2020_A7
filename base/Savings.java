//Savings.java

public class Savings extends Account
{
    private double interest;

    Savings()
    {

    }//end constructor

    Savings(double B, double I)
    {
        balance = B;
        interest = I;
    }//end overloaded constructor
}//end class def