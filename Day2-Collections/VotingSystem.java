import java.util.*;
public class VotingSystem {
    final private Map<String, Integer> voteMap = new HashMap<>();
    final private Map<Integer, String> voteOrderMap = new LinkedHashMap<>();

    private int voteId = 1; 
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(voteId++, candidate);
    }
    public void displayVoteOrder() {
        System.out.println("\nVote Order (LinkedHashMap):");
        for (Map.Entry<Integer, String> entry : voteOrderMap.entrySet()) {
            System.out.println("Vote " + entry.getKey() + " -> " + entry.getValue());
        }
    }
    public void displaySortedResults() {
        System.out.println("\nResults (TreeMap - Sorted by Candidate):");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    public void displayVoteCounts() {
        System.out.println("\nRaw Vote Counts (HashMap):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");
        system.displayVoteOrder();
        system.displayVoteCounts();
        system.displaySortedResults();
    }
}
