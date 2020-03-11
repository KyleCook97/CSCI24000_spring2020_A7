//User.java

abstract class User
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
    }//end checkID

    boolean checkPIN(String PINstring)
    {
        return PIN.equals(PINstring);
    }//end checkPIN

    String getID()
    {
        return ID;
    }//end getID

    String getPIN()
    {
        return PIN;
    }//end getPIN
}//end class def