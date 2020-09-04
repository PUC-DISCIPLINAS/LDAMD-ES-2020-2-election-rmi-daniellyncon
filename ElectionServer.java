import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ElectionServer {    
    public static void main(String args[]) {
        
        // if (System.getSecurityManager() == null) {
        //     System.setSecurityManager(new SecurityManager()); 
        // }

        try {
            
            ElectionInterface election = new ElectionServant();
            ElectionInterface stub = (ElectionInterface) UnicastRemoteObject.exportObject(election, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("election", stub);
            System.err.println("Server ready...");

        } catch (Exception e) {
            
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    } 

}