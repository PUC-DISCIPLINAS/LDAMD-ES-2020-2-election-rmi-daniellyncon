import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Candidate extends UnicastRemoteObject {
    public String candidateName;
    public int votes;

    public Candidate (String name) throws RemoteException{
        this.candidateName = name;
    }    

    public void addVote () {
        this.votes++;
    }

    public String getCandidateName() {
        return this.candidateName;
    }

	public void showResults(int totalVotes) {
        System.out.println(this.candidateName + "\t" + (float)this.votes/totalVotes*100 + "%");
	}

}