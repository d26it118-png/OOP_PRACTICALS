import java.util.Random;
import java.util.Scanner;

public class A3_RPSLS {

    enum GameMove {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    static int determineWinner(GameMove playerChoice, GameMove opponentChoice) {
        if (playerChoice == opponentChoice) {
            return 0; // draw
        }

        switch (playerChoice) {
            case ROCK:
                return (opponentChoice == GameMove.SCISSORS || opponentChoice == GameMove.LIZARD) ? 1 : -1;
            case PAPER:
                return (opponentChoice == GameMove.ROCK || opponentChoice == GameMove.SPOCK) ? 1 : -1;
            case SCISSORS:
                return (opponentChoice == GameMove.PAPER || opponentChoice == GameMove.LIZARD) ? 1 : -1;
            case LIZARD:
                return (opponentChoice == GameMove.SPOCK || opponentChoice == GameMove.PAPER) ? 1 : -1;
            case SPOCK:
                return (opponentChoice == GameMove.SCISSORS || opponentChoice == GameMove.ROCK) ? 1 : -1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGen = new Random();
        int playerScore = 0;
        int compScore = 0;

        System.out.println("===== Rock Paper Scissors Lizard Spock =====");
        System.out.println("Moves: ROCK, PAPER, SCISSORS, LIZARD, SPOCK");

        for (int roundNo = 1; roundNo <= 5; roundNo++) {
            System.out.println("\nRound " + roundNo);

            // Computer selection
            GameMove compMove = GameMove.values()[randomGen.nextInt(5)];

            // Player selection
            System.out.print("Enter your move: ");
            String rawInput = inputScanner.next().toUpperCase();

            GameMove playerMove;
            try {
                playerMove = GameMove.valueOf(rawInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Move! Round Skipped.");
                continue;
            }

            int roundOutcome = determineWinner(playerMove, compMove);
            System.out.println("Player : " + playerMove);
            System.out.println("Computer : " + compMove);

            if (roundOutcome == 1) {
                System.out.println("You Win this Round!");
                playerScore++;
            } else if (roundOutcome == -1) {
                System.out.println("Computer Wins this Round!");
                compScore++;
            } else {
                System.out.println("Round Draw!");
            }
        }

        System.out.println("\n===== Final Result =====");
        System.out.println("Player Score : " + playerScore);
        System.out.println("Computer Score: " + compScore);

        if (playerScore > compScore) {
            System.out.println("Overall Winner: You win " + playerScore + "-" + compScore);
        } else if (compScore > playerScore) {
            System.out.println("Overall Winner: Computer wins " + compScore + "-" + playerScore);
        } else {
            System.out.println("Overall Result: Match Draw");
        }
    }
}