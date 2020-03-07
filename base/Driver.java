//Driver.java

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

abstract class Driver
{
    public static void main(String args[]) 
    {
        String tempID;
        String tempPIN;
        boolean keepGoing = true;
        Scanner input = new Scanner(System.in);
        Admin a = new Admin("00000", "12345"); //Temp User for method testing
        //Customer c = new Customer("98765", "00000"); //Temp User for method testing

        Customer loggedInCustomer = null;
        ArrayList<Customer> custArr = new ArrayList<>();
        custArr.add(new Customer("11111", "12121"));
        custArr.add(new Customer("22222", "23232"));
        custArr.add(new Customer("33333", "34343"));

        while(keepGoing == true)
        {
            System.out.println("Please type your ID :");
            tempID = input.nextLine();   
            System.out.println("Please type your PIN :");
            tempPIN = input.nextLine();
            
            for (Customer customer : custArr)
            {
                if (customer.checkID(tempID))
                {
                    if (customer.checkPIN(tempPIN))
                    {
                        loggedInCustomer = customer;

                        break;
                    }
                }
            }

            if (loggedInCustomer != null)
            {
                System.out.println("Successful Login");
                keepGoing = false;
            }
            else
            {
                System.out.println("Invalid ID/PIN combination. Exiting...");
                keepGoing = false;
            }
            // System.out.println("ENTER YOUR ID: ");
            // tempID = input.nextLine();
            // if (a.checkID(tempID) == true)
            // {
            //     System.out.println("you are an admin");
            //     keepGoing = false;
            // }//end if

            // else if (c.checkID(tempID) == true)
            // {
            //     System.out.println("you are a customer");
            //     keepGoing = false;
            // }//end if

            // else
            // {
            //     System.out.println("INCORRECT ID ENTERED. EXITING...");
            //     keepGoing = false;
            // }//end else
        }//end while

    }//end main
}//end class def