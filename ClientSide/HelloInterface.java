import java.rmi.*;
public interface HelloInterface extends Remote {
/**
* This remote method returns a message.
* @param name - a String containing a name.
* @return a String message.
*/
public String checkStatus(String message)
throws java.rmi.RemoteException;
public String doYouWanttoVote(String message)
throws java.rmi.RemoteException;
public void incrementVotes(String message)
throws java.rmi.RemoteException;
public  String getVotes(String message)
throws java.rmi.RemoteException;
} //end interface
