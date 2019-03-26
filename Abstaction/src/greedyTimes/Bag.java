package greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentCapacity;
    private long gold;
    private Map<String, Long> cash;
    private long totalCash;
    private Map<String, Long> gems;
    private long totalGems;
    private boolean goldAdded;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.gold = 0;
        this.cash = new HashMap<>();
        this.totalCash = 0;
        this.gems = new HashMap<>();
        this.totalGems = 0;
        this.goldAdded = false;
    }


    public void addCash(String item, long amount) {
        if (this.hasFreeCapacity(amount) && this.totalGems >= this.totalCash + amount) {
            if (!this.cash.containsKey(item)) {
                this.cash.put(item, amount);
            } else {
                this.cash.put(item, this.cash.get(item) + amount);
            }
            this.totalCash += amount;
            this.currentCapacity += amount;
        }
    }

    public void addGems(String item, long amount) {
        if (this.hasFreeCapacity(amount) && this.gold >= this.totalGems + amount) {
            if (!this.gems.containsKey(item)) {
                this.gems.put(item, amount);
            } else {
                this.gems.put(item, this.gems.get(item) + amount);
            }
            this.totalGems += amount;
            this.currentCapacity += amount;
        }
    }


    public void addGold(long amount) {
        if (this.hasFreeCapacity(amount)) {
            this.gold += amount;
            this.currentCapacity += amount;
            goldAdded = true;
        }
    }

    private boolean hasFreeCapacity(long amount) {
        return this.currentCapacity + amount <= this.capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (goldAdded) {
            sb.append("<Gold> $").append(this.gold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.gold).append(System.lineSeparator());
        }
        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());

            gems.entrySet().stream().sorted((a, b) -> {
                int result = b.getKey().compareTo(a.getKey());

                if (result == 0) {
                    result = a.getValue().compareTo(b.getValue());
                }

                return result;
            }).forEach(a -> sb.append("##").append(a.getKey()).append(" - ").append(a.getValue()).append(System.lineSeparator()));
        }

        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());
            cash.entrySet().stream().sorted((a, b) -> {
                int result = b.getKey().compareTo(a.getKey());

                if (result == 0) {
                    result = a.getValue().compareTo(b.getValue());
                }

                return result;
            }).forEach(a -> sb.append("##").append(a.getKey()).append(" - ").append(a.getValue()).append(System.lineSeparator()));
        }
        return sb.toString();
    }
}
