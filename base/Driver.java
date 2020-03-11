//Driver.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

abstract class Driver
{
    public static void main(String args[]) 
    {
        String tempID = "00001"; //defult account number
        String tempPIN = "00001"; //defult acount pin
        double savBal = 0.0;
        double cheBal = 0.0;
        double interest = 0.314;
        boolean keepGoing = true;
        boolean cont = true; 
        boolean loggedIn = false;
        int selection;

        Admin a = new Admin("00000", "12345"); //Beacuse we will only ever need a single Admin we can just initalize them here and not in the .txt file
        ArrayList<Customer> custArr = new ArrayList<>();
        ArrayList<Savings> savArr = new ArrayList<>();
        ArrayList<Checking> cheArr = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try
        {
            Scanner fileRead = new Scanner(new File("accounts.dat"));
            
            fileRead.useDelimiter(",");
            while (fileRead.hasNext())
            {
                
                if (fileRead.hasNext())
                    tempID = fileRead.next();

                if (fileRead.hasNext())
                    tempPIN = fileRead.next();

                if (fileRead.hasNextDouble())
                    savBal = fileRead.nextDouble();

                if (fileRead.hasNextDouble())
                    cheBal = fileRead.nextDouble();

                fileRead.nextLine();

                custArr.add(new Customer(tempID, tempPIN));
                savArr.add(new Savings(savBal, interest));
                cheArr.add(new Checking(cheBal));
            }//end while
        }//end try

        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred when reading the file.");
            e.printStackTrace();
        }//end catch

        // Testing if file was reading correctly
        // System.out.println(custArr.get(0).getID());
        // System.out.println(custArr.get(0).getPIN());
        // System.out.println(savArr.get(0).getBalance());
        // System.out.println(cheArr.get(0).getBalance());
        // System.out.println("-------------------------");
        // System.out.println(custArr.get(1).getID());
        // System.out.println(custArr.get(1).getPIN());
        // System.out.println(savArr.get(1).getBalance());
        // System.out.println(cheArr.get(1).getBalance());

        while(keepGoing == true)
        {
            System.out.println("Please type your ID :");
            tempID = input.nextLine();   
            System.out.println("Please type your PIN :");
            tempPIN = input.nextLine();

            if (a.checkID(tempID))
            {
                if (a.checkPIN(tempPIN))
                {
                    loggedIn = true;
                    System.out.println("Successful Admin Login");

                    while (cont == true)
                    {
                        System.out.println("-----------------------------");
                        System.out.println("Please make a selection: ");
                        System.out.println("1.) Display Users");
                        System.out.println("2.) Exit");
                        System.out.println("-----------------------------");

                        selection = input.nextInt();

                        if (selection == 1)
                        {
                            System.out.println("Showing all users: ");
                            a.getUsers(custArr);
                        }//end if
                        else if (selection == 2)
                        {
                            System.out.println("Exiting");
                            cont = false;
                        }//end else if
                        
                    }//end while
                    
                }//end while
            }//end while
            
            if (loggedIn == false)
            {
                for (Customer customer : custArr)
                {
                    if (customer.checkID(tempID))
                    {
                        if (customer.checkPIN(tempPIN))
                        {
                            loggedIn = true;
                            System.out.println("Successful Customer Login");
                            
                            break;
                        }//end if
                    }//end if
                }//end for
            }//end if

            if (loggedIn == true)
            {
                keepGoing = false;
            }//end if
            else
            {
                System.out.println("Invalid ID/PIN combination. Exiting...");
                keepGoing = false;
            }//end else
        }//end while

    }//end main
}//end class def