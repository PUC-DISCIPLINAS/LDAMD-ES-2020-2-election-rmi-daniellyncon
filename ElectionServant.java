import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ElectionServant implements ElectionInterface, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int totalVotes;
    private Vector<Candidate> candidates;
    private Map<String, Candidate> voting;
    

    public ElectionServant() throws RemoteException {
        this.totalVotes = 0;
        this.candidates = new Vector<>();
        this.voting = new HashMap<>();
        addCandidates();
    }

    @Override
    public synchronized boolean vote(String candidateName, String voterName) { 
        boolean foundCandidate = false;
        Candidate candidate = null;
        for(Candidate c : this.candidates) {
            if(c.getCandidateName().equals(candidateName)){
                foundCandidate = true;
                candidate = c;
                break;
            }
        }
        if (!voting.containsKey(HashMD5.generateHString(voterName)) && foundCandidate) {
            candidate.addVote();
            this.totalVotes++;
            return true;
        }
        return false;
    }

    @Override
    public synchronized void result() throws RemoteException {
        System.out.println("Candidate name \t votes");
        for (Candidate c : this.candidates) {
            c.showResults(totalVotes);
        }
    }

    public void addCandidates() throws RemoteException {
        this.candidates.add(new Candidate("Bonoro"));
        this.candidates.add(new Candidate("Molusco"));
    }

    @Override
    public void candidatesList() throws RemoteException {
        System.out.println("Candidates:");
        for (Candidate c : this.candidates) {
            System.out.println(c.getCandidateName());
        }

    }
}