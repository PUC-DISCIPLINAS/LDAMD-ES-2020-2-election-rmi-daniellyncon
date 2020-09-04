package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ElectionClient {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            ElectionInterface stub = (ElectionInterface) registry.lookup("election");
            System.out.println("Welcome to 2020 election!");
            System.out.println("Enter your name to begin:");
            String voterName = scanner.nextLine();

            while(voterName.equals(null) || voterName.length() == 0) {
                System.out.println("Please, provide your name to continue...");
                voterName = scanner.nextLine();
            }

            System.out.println("Thanks "+voterName+". Here is the list of the candidates available:");
            List<String> candidatesList = stub.candidatesList();
            for (String candidateName : candidatesList) {
                System.out.println(candidateName);
            }
            System.out.print("Please type the exact name of your candidate:");
            String vote = scanner.nextLine();
            VoteManager vt = new VoteManager(vote, voterName);
            vt.start();
            System.out.println("Thanks for voting! Here are the current results:");
            Map<String, Integer> results = stub.result();
            for(String s: results.keySet()) {
                System.out.println(s + "\t\t\t"+ results.get(s));
            }

            scanner.close();
        
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}