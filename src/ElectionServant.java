package src;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectionServant implements ElectionInterface, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private CandidateDao candidates;
    private Map<String, Candidate> voting;
    

    public ElectionServant() throws RemoteException {
        this.candidates = new CandidateDao();
        this.voting = new HashMap<>();
        
    }

    @Override
    public synchronized boolean vote(String candidateName, String voterName) { 
        boolean foundCandidate = false;
        Candidate candidate = null;
        for(Candidate c : this.candidates.getAll()) {
            if(c.getCandidateName().equals(candidateName)){
                foundCandidate = true;
                candidate = c;
                break;
            }
        }
        if (!voting.containsKey(HashMD5.generateHString(voterName)) && foundCandidate) {
            candidate.addVote();
            FileSerialization.saveToFile(candidates.getAll());
            return true;
        }
        return false;
    }

    @Override
    public synchronized Map<String, Integer> result() throws RemoteException {
        System.out.println("Candidate name \t votes");
        Map<String, Integer> results = new HashMap<>();
        for (Candidate c : this.candidates.getAll()) {
            results.put(c.candidateName, c.votes);
        }
        return results;
    }

    @Override
    public List<String> candidatesList() throws RemoteException {
        List<String> candidateNames = new ArrayList<>();
        for (Candidate c : this.candidates.getAll()) {
            candidateNames.add(c.getCandidateName());
        }
        return candidateNames;
    }
}