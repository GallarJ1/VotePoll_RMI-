import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface {
      private int yes = 0;
      private int no = 0;
      private int dont_care = 0;
   public HelloImpl() throws RemoteException {
      super( );
   }
   public String checkStatus(String message) 
                 throws RemoteException {
      if((message.trim()).equals("1"))
      {
        return "Vote Recorded";
      }
      else if((message.trim()).equals("2"))
      {
        return "Vote Recorded";
      }
      else if((message.trim()).equals("3"))
      {
        return "Vote Recorded";
      }
      else
      {
        return "Incorrect input try again";
      }
   }
              
      public String doYouWanttoVote(String message) throws RemoteException
      {
        if((message.trim()).equals("I want to vote"))
        {
          return "Vote(1) yes, (2) no, or (3) don't care" ;
        }
        else
        {
          return "Incorrect input try again";
        }
      }
      public synchronized void incrementVotes(String message) throws java.rmi.RemoteException
      {
       if((message.trim()).equals("1"))
        {
          yes++;
        }
        else if((message.trim()).equals("2"))
        {
          no++;
        }
        else if((message.trim()).equals("3"))
        {
          dont_care++;
        }
      } 

      public synchronized String getVotes(String message) throws java.rmi.RemoteException
      {
       if((message.trim()).equals("."))
       {
         return "now exiting";
       }
       else
       {
         return "Scores are: " + yes + " yes, " + no + " no, " + dont_care + " dont care";
       }
      }
   } //end class


