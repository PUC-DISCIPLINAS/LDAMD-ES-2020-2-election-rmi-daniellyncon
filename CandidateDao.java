import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

public class CandidateDao implements Dao<Candidate> {

    private Vector<Candidate> candidates = new Vector<>();

    public CandidateDao() throws RemoteException {
        // this.candidates = FileSerialization.readFile();
        // if(this.candidates.size() == 0) {
            candidates.add(new Candidate("Bonoro"));
            candidates.add(new Candidate("Molusco"));
        // }
    }

    @Override
    public List<Candidate> getAll() {
        return candidates;
    }

    @Override
    public void save(Candidate c) {
        candidates.add(c);
    }

    @Override
    public void delete(Candidate t) {
        candidates.remove(t);
    }
    
}
