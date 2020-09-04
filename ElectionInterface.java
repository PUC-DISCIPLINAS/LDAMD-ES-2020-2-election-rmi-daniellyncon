import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.List;

public interface ElectionInterface extends Remote {

    List<String> candidatesList() throws RemoteException;
    boolean vote(String candidate, String voterName) throws RemoteException;
    Map<String, Integer> result() throws RemoteException;

}