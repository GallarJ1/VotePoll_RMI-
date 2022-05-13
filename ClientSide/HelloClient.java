import java.io.*;
import java.rmi.*;
public class HelloClient {
   public static void main(String args[]) {
      try {
         int RMIPort;         
         String hostName;
         InputStreamReader is = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(is);
         System.out.println("Enter the RMIRegistry host namer:");
         hostName = br.readLine();
         System.out.println("Enter the RMIregistry port number:");
         String portNum = br.readLine();
         RMIPort = Integer.parseInt(portNum);
         String registryURL = 
            "rmi://" + hostName+ ":" + portNum + "/hello";  
         // find the remote object and cast it to an interface object
         HelloInterface h =
           (HelloInterface)Naming.lookup(registryURL);
         System.out.println("Lookup completed " );
         // invoke the remote method
         System.out.println("Do you want to vote");
         while(true)
         {
           String message = br.readLine();
           String holder = h.doYouWanttoVote(message);
           if((holder.trim()).equals("Vote(1) yes, (2) no, or (3) don't care"))
           {
             System.out.println(holder);
             break;
           }
           else
           {
            System.out.println(holder);
           }
          }
          while(true)
          {
            String message = br.readLine();
            String holder = h.checkStatus(message);
            h.incrementVotes(message); //something wrong.
            if((message.trim()).equals("1") || (message.trim()).equals("2") || (message.trim()).equals("3")) // something wrong
            {
              System.out.println(holder);
              break;
            }
            else
            {
              System.out.println(holder);
            }
          }
          while(true)
          {
            System.out.println("Press anything number to see results or . to exit");
            String message = br.readLine();
            String holder = h.getVotes(message);
            if((holder.trim()).equals("now exiting"))
            {
              System.out.println(holder);
              break;
            }
            else
            {
              System.out.println(holder);
            }
          }       
      } // end try 
      catch (Exception e) {
         System.out.println("Exception in HelloClient: " + e);
      } 
   } //end main
}//end class
