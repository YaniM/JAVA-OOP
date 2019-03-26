package greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        Bag bag = new Bag(bagCapacity);

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i+=2) {
            String item = input[i];
            long amount = Long.parseLong(input[i+1]);

            if(item.length()==3){
                bag.addCash(item,amount);
            }else if(item.toLowerCase().endsWith("gem") && item.length()>3){
                bag.addGems(item,amount);
            }else if(item.equalsIgnoreCase("gold")){
                bag.addGold(amount);
            }
        }
        System.out.println(bag.toString());
    }
}
