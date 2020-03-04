//Driver.java

import java.util.Scanner;

public class Driver
{
    public static void main(String args[]) 
    {
        String tempID;

        Scanner s = new Scanner(System.in);

        User u = new User("12121", "98765");

        System.out.println("Enter your ID: ");
        tempID = s.nextLine();

        System.out.println(u.checkID(tempID));


    }//end main
}//end class def