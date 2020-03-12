//Driver.java

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

abstract class Driver
{
    public void load()
    {
        
    }
    public static void main(String args[]) 
    {
        String tempID = "00001"; //defult account number
        String tempPIN = "00001"; //defult acount pin
        double savBal = 0.0;
        double cheBal = 0.0;
        double interest = 0.0314;
        boolean keepGoing = true;
        boolean cont = true; 
        boolean loggedIn = false;
        int selection;
        int time;
        double amount;

        Admin a = new Admin("00000", "12345"); //Beacuse we will only ever need a single Admin we can just initalize them here and not in the .txt file
        ArrayList<Customer> custArr = new ArrayList<>();
        ArrayList<Savings> savArr = new ArrayList<>();
        ArrayList<Checking> cheArr = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Creating new file...");
        try 
        {
            File myObj = new File("accounts.dat");
            if (myObj.createNewFile()) 
            {
              System.out.println("File created: " + myObj.getName() + "\n");
            } 
            else 
            {
              System.out.println("File already exists." + "\n");
            }
        } 
        catch (IOException x) 
        {
            System.out.println("An error occurred.");
            x.printStackTrace();
        }
        System.out.println("Loading file..." + "\n");
        try
        {
            File inFile = new File("accounts.dat");
            Scanner fileRead = new Scanner(inFile);
            
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
            System.out.println("An error occurred when reading the file." + "\n");
            e.printStackTrace();
        }//end catch

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
                        System.out.println("2.) Add User");
                        System.out.println("3.) Delete User");
                        System.out.println("4.) Apply Interest");
                        System.out.println("5.) Exit");
                        System.out.println("-----------------------------");

                        selection = input.nextInt();

                        if (selection == 1)
                        {
                            System.out.println("Showing all users: ");
                            a.getUsers(custArr, savArr, cheArr);
                        }//end if
                        else if (selection == 2)
                        {
                            System.out.println("Enter new user's ID and PIN in XXXXX format: ");
                            tempID = input.next();
                            tempPIN = input.next();
                            a.addUser(custArr, savArr, cheArr, tempID, tempPIN, interest);
                        }//end if
                        else if (selection == 3)
                        {
                            System.out.println("Enter user's ID that you wish to remove: ");
                            tempID = input.next();
                            a.delUser(custArr, savArr, cheArr, tempID);
                        }
                        else if (selection == 4)
                        {
                            System.out.println("Input the amount of months have passed: ");
                            time = input.nextInt();
                            a.addInterest(savArr, time);
                        }
                        else if (selection == 5)
                        {
                            System.out.println("Exiting");
                            cont = false;
                        }//end else if
                        
                    }//end while
                    
                }//end if
            }//end if
            
            if (loggedIn == false)
            {
                int i = 0;
                for (Customer customer : custArr)
                {
                    if (customer.checkID(tempID))
                    {
                        if (customer.checkPIN(tempPIN))
                        {
                            loggedIn = true;
                            Customer currentUser = new Customer(tempID, tempPIN);
                            Savings currentSav = new Savings(savArr.get(i).getBalance(), interest);
                            Checking currentChe = new Checking(cheArr.get(i).getBalance());
                            System.out.println("Successful Customer Login");
                            while (cont == true)
                            {
                                System.out.println("-----------------------------");
                                System.out.println("Please make a selection: ");
                                System.out.println("1.) Get Savings Balance");
                                System.out.println("2.) Deposit into Savings");
                                System.out.println("3.) Withdraw from Savings");
                                System.out.println("4.) Get Checking Balance");
                                System.out.println("5.) Deposit into Checking");
                                System.out.println("6.) Withdraw from Checking");
                                System.out.println("7.) Exit");
                                System.out.println("-----------------------------");

                                selection = input.nextInt();

                                if (selection == 1)
                                {
                                    System.out.println("Your current balance is: $" + Math.round(currentSav.getBalance() * 100d)/100d);
                                }
                                else if (selection == 2)
                                {
                                    System.out.println("Enter amount you wish to deposit: ");
                                    amount = input.nextDouble();
                                    currentSav.deposit(amount);
                                    System.out.println("You have deposited: $" + amount + " into you Savings account.");
                                }
                                else if (selection == 3)
                                {
                                    System.out.println("Enter amount you wish to withdraw: ");
                                    amount = input.nextDouble();
                                    currentSav.withdraw(amount);
                                }
                                else if (selection == 4)
                                {
                                    System.out.println("Your current balance is: $" + Math.round(currentChe.getBalance() * 100d)/100d);
                                }
                                else if (selection == 5)
                                {
                                    System.out.println("Enter amount you wish to deposit: ");
                                    amount = input.nextDouble();
                                    currentChe.deposit(amount);
                                    System.out.println("You have deposited: $" + amount + " into you Checking account.");
                                }
                                else if (selection == 6)
                                {
                                    System.out.println("Enter amount you wish to withdraw: ");
                                    amount = input.nextDouble();
                                    currentChe.withdraw(amount);
                                }
                                else if (selection == 7)
                                {
                                    System.out.println("Exiting");
                                    savArr.get(i).setBalance(currentSav.getBalance());
                                    cheArr.get(i).setBalance(currentChe.getBalance());
                                    cont = false;
                                }
                            }
                            break;
                        }//end if
                    }//end if
                    i++;
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

        try 
        {
            FileWriter outFile = new FileWriter("accounts.dat");
            for (int k = 0; k < custArr.size(); k ++)
            {
                outFile.write(custArr.get(k).getID() + "," + custArr.get(k).getPIN() + "," + savArr.get(k).getBalance() + "," + cheArr.get(k).getBalance() + "," + "\n");
            }
            outFile.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//end main
}//end class def