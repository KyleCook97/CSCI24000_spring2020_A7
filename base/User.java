//User.java

public class User
{
    protected String ID;
    protected String PIN;

    User()
    {

    }//end constructor

    User(String I, String P)
    {
        ID = I;
        PIN = P;
    }//end overloaded constructor

    boolean checkID(String IDstring)
    {
        if (ID == IDstring)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
}//end class def