//Admin.java

import java.util.ArrayList;

public class Admin extends User
{   
    Admin()
    {

    }//end constructor

    Admin(String I, String P)
    {
        ID = I;
        PIN = P;
    }//end overloaded constructor

    public void getUsers(ArrayList<Customer> custArray, ArrayList<Savings> savArray, ArrayList<Checking> cheArray)
    {
        for (int i = 0; i < custArray.size(); i++)
        {
            System.out.println("ID: " + custArray.get(i).getID() + " PIN: " + custArray.get(i).getPIN());
            System.out.println( "Savings Account: $" + Math.round(savArray.get(i).getBalance() * 100d)/100d + " Checking Account: $" + cheArray.get(i).getBalance());
            System.out.println(" ");
        }//end for
    }//end getUsers

    public void addUser(ArrayList<Customer> custArray, ArrayList<Savings> savArray, ArrayList<Checking> cheArray, String tID, String tPIN, double interest)
    {
        custArray.add(new Customer(tID, tPIN));
        savArray.add(new Savings(0.0, interest));
        cheArray.add(new Checking(0.0));

    }//end addUser

    public void delUser(ArrayList<Customer> custArray, ArrayList<Savings> savArray, ArrayList<Checking> cheArray, String userID)
    {
        int i = 0;

        for (Customer customer  : custArray)
        {
            if (customer.getID().equals(userID))
            {
                if (savArray.get(i).getBalance() == 0.0 && cheArray.get(i).getBalance() == 0.0)
                {
                    custArray.remove(i);
                    savArray.remove(i);
                    cheArray.remove(i);
                    System.out.println("User " + userID + " has been deleted.");
                    break;
                }//end if
                else
                {
                    System.out.println("User still has money in their accounts.");
                    break;
                }//end else
                
            }
            else if (i == custArray.size() - 1)
            {
                System.out.println("No user with that ID. Please enter a valid user ID");
            }//end else
            i++;
        }//end for
    }//end delUser

    public void addInterest(ArrayList<Savings> savArray, int time)
    {
        double tempSavBal;

        for (int i = 0; i < savArray.size(); i++)
        {
            tempSavBal = savArray.get(i).getBalance();
            savArray.get(i).deposit(tempSavBal * (savArray.get(i).getInterest() * time));

        }
    }
}//end class def