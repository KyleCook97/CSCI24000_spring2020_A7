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
        return ID.equals(IDstring);
    }

    boolean checkPIN(String PINstring)
    {
        return PIN.equals(PINstring);
    }

    String getID()
    {
        return ID;
    }

    String getPIN()
    {
        return PIN;
    }
}//end class def