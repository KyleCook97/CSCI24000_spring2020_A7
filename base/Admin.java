//Admin.java

import java.util.ArrayList;

public class Admin extends User
{

    private ArrayList<Customer> custArray = new ArrayList<>();
    
    Admin()
    {

    }//end constructor

    Admin(String I, String P)
    {
        ID = I;
        PIN = P;
    }//end overloaded constructor

    public void getUsers(ArrayList<Customer> custArray)
    {
        for (int i = 0; i < custArray.size(); i++)
        {
            System.out.println("ID: " + custArray.get(i).getID() + " PIN: " + custArray.get(i).getPIN());
        }//end for
    }//end getUsers
}//end class def