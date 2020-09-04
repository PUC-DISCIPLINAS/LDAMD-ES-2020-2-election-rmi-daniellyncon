import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Candidate extends UnicastRemoteObject {
    public String candidateName;
    public int votes;

    public Candidate (String name) throws RemoteException{
        setCandidateName(name);
        this.votes = 0;
    }    

    public void addVote () {
        this.votes++;
    }

    public String getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String name) {
        this.candidateName = name;
    }

	

}