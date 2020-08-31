import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class VoteManager extends Thread {
    private String thisCandidate;
    private String thisVoter;

	public VoteManager (String candidateName, String voterName) {
        this.thisCandidate = candidateName;
        this.thisVoter = voterName;
	}

	@Override
	public void run() {
		while (true) {

			try {
				Registry registry = LocateRegistry.getRegistry("localhost");
				ElectionInterface election = (ElectionInterface) registry.lookup("election");

				boolean votedSuccessfully = election.vote(thisCandidate, thisVoter);

				if (votedSuccessfully) {
					System.out.println("Vote registered succesfully.");
				} else {
					System.out.println("You have already voted...");
				}

				break;

			} catch (RemoteException | NotBoundException e) {
				try {
					sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}