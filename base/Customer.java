import java.io.Serializable;

//Customer.java

public class Customer extends User implements Serializable
{
    Customer()
    {

    }//end constructor

    Customer(String I, String P)
    {
        ID = I;
        PIN = P;
    }//end overloaded constructor
}//end class def