import java.rmi.Remote;
import java.rmi.RemoteException;
//import java.util.Vector;

public interface ElectionInterface extends Remote {

    void candidatesList() throws RemoteException;
    boolean vote(String candidate, String voterName) throws RemoteException;
    void result() throws RemoteException;

}