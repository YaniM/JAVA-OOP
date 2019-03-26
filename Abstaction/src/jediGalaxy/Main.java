package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensionSize[0];
        int cols = dimensionSize[1];

        Galaxy galaxy = new Galaxy(rows, cols);

        StarsManipulation starsManipulation = new StarsManipulation(galaxy);
        String input = scanner.nextLine();

        long starsCount = 0;

        while (!input.equals("Let the Force be with you")) {

            int[] playerCoordinates = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];

            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            starsManipulation.destroyStars(evilRow,evilCol);
            starsCount += starsManipulation.playerMove(playerRow, playerCol);

            input = scanner.nextLine();
        }
        System.out.println(starsCount);
    }
}
