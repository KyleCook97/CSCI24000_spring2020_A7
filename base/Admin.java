//Admin.java

import java.util.ArrayList;

public class Admin extends User
{

    private ArrayList<Customer> custArray = new ArrayList<>();
    
    Admin()
    {

    }

    Admin(String I, String P)
    {
        ID = I;
        PIN = P;
    }//end overloaded constructor
}