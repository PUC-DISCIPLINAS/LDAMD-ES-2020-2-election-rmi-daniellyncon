import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectionInterface extends Remote {

    void candidatesList() throws RemoteException;
    boolean vote(String candidate, String voterName) throws RemoteException;
    void result() throws RemoteException;

}