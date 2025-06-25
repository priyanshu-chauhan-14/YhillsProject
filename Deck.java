// Date 24 June 2025
import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();
    private final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    private final String[] ranks = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"
    };

    public Deck() {
        initializeDeck();
    }

    public void initializeDeck() {
        cards.clear();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void printDeck() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty!");
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Deck has been shuffled.");
    }

    public void sort() {
        cards.sort(new Comparator<Card>() {
            public int compare(Card c1, Card c2) {
                int suitCompare = Arrays.asList(suits).indexOf(c1.getSuit()) - Arrays.asList(suits).indexOf(c2.getSuit());
                if (suitCompare != 0) return suitCompare;
                return Arrays.asList(ranks).indexOf(c1.getRank()) - Arrays.asList(ranks).indexOf(c2.getRank());
            }
        });
        System.out.println("Deck has been sorted.");
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty! Cannot draw.");
            return null;
        }
        Random rand = new Random();
        return cards.remove(rand.nextInt(cards.size()));
    }

    public List<Card> drawMultipleCards(int n) {
        List<Card> drawnCards = new ArrayList<>();
        if (n > cards.size()) {
            System.out.println("Not enough cards left in the deck.");
            return drawnCards;
        }
        for (int i = 0; i < n; i++) {
            drawnCards.add(drawCard());
        }
        return drawnCards;
    }

    public int remainingCards() {
        return cards.size();
    }
}
