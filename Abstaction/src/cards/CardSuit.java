package cards;

public enum  CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int cardValue;

    CardSuit(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return cardValue;
    }
}
