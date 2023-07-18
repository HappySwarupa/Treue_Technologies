import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Class representing a registered user
class User {
    private final String username;
    private final String password; // In a real system, this should be hashed and salted

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Class representing a candidate in the election
class Candidate {
    private final String name;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class representing the options (candidates) available for voting
class Ballot {
    private final List<Candidate> candidates;

    public Ballot() {
        candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
}

// Main class responsible for managing the voting process
 class VotingSystem {
    private final Map<String, User> registeredUsers;
    private final Ballot ballot;
    private final Map<String, Integer> voteCounts;

    public VotingSystem() {
        registeredUsers = new HashMap<>();
        ballot = new Ballot();
        voteCounts = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        // In a real system, this should handle hashing and salting of passwords
        User user = new User(username, password);
        registeredUsers.put(username, user);
    }

    public void addCandidate(String candidateName) {
        Candidate candidate = new Candidate(candidateName);
        ballot.addCandidate(candidate);
        voteCounts.put(candidateName, 0);
    }

    public void castVote(String username, String candidateName) {
        if (!registeredUsers.containsKey(username)) {
            System.out.println("Error: User not registered.");
            return;
        }

        if (!voteCounts.containsKey(candidateName)) {
            System.out.println("Error: Candidate not found.");
            return;
        }

        // In a real system, you would check if the user has already voted and other validations.

        // Increment the vote count for the selected candidate
        int currentVotes = voteCounts.get(candidateName);
        voteCounts.put(candidateName, currentVotes + 1);

        System.out.println("Vote cast successfully!");
    }

    public void showResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : voteCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.registerUser("user1", "password1");
        votingSystem.registerUser("user2", "password2");

        votingSystem.addCandidate("Candidate A");
        votingSystem.addCandidate("Candidate B");

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (!votingSystem.registeredUsers.containsKey(username) ||
                    !votingSystem.registeredUsers.get(username).getPassword().equals(password)) {
                System.out.println("Invalid username or password. Please try again.");
                i--;
                continue;
            }

            System.out.println("Candidates:");
            for (Candidate candidate : votingSystem.ballot.getCandidates()) {
                System.out.println(candidate.getName());
            }

            System.out.print("Enter your candidate choice: ");
            String candidateName = scanner.nextLine();
            votingSystem.castVote(username, candidateName);
        }

        votingSystem.showResults();
    }
}