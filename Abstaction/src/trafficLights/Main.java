package trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lightsInput = scanner.nextLine().split("\\s+");

        int numbersOfChange = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String currentLight : lightsInput) {
            TrafficLight trafficLight = new TrafficLight(Lights.valueOf(currentLight));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < numbersOfChange; i++) {
            StringBuilder sb = new StringBuilder();
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                sb.append(trafficLight).append(" ");
            }
            System.out.println(sb.toString());
        }

    }
}
