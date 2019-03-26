package cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Card card = new Card(CardSuit.valueOf(cardSuit),CardRank.valueOf(cardRank));

        System.out.println(String.format("Card name: %s of %s; Card power: %d",cardRank,cardSuit,card.calculatePower()));
    }
}
