package telephony;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> callables = new ArrayList<>();
        List<String> browsables = new ArrayList<>();

        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        callables.addAll(Arrays.asList(phoneNumbers));

        String[] urls = scanner.nextLine().split("\\s+");
        browsables.addAll(Arrays.asList(urls));

        Smartphone smartphone = new Smartphone(callables, browsables);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
