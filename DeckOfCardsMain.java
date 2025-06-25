// Date 24 June 2025 
//This is the deck of cards game. This file contains the code which will interact with the user
import java.util.*;

public class DeckOfCardsMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deck deck = new Deck();
        int choice;

        System.out.println(" Welcome to Deck of Cards Simulator ");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Print Deck");
            System.out.println("2. Shuffle Deck");
            System.out.println("3. Sort Deck");
            System.out.println("4. Draw One Card");
            System.out.println("5. Draw Multiple Cards");
            System.out.println("6. Reset Deck");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    deck.printDeck();
                    break;
                case 2:
                    deck.shuffle();
                    break;
                case 3:
                    deck.sort();
                    break;
                case 4:
                    Card card = deck.drawCard();
                    if (card != null) System.out.println("You drew: " + card);
                    break;
                case 5:
                    System.out.print("How many cards to draw? ");
                    int n = sc.nextInt();
                    List<Card> drawn = deck.drawMultipleCards(n);
                    for (Card c : drawn) {
                        System.out.println("You drew: " + c);
                    }
                    break;
                case 6:
                    deck.initializeDeck();
                    System.out.println("Deck reset to original 52 cards.");
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println("Cards left in deck: " + deck.remainingCards());

        } while (choice != 7);

        sc.close();
    }
}
