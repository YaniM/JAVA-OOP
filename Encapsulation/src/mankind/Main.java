package mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] studentParams = scanner.nextLine().split("\\s+");
        String[] workerParams = scanner.nextLine().split("\\s+");

        try {
            Student student = new Student(studentParams[0], studentParams[1], studentParams[2]);
            Worker worker = new Worker(workerParams[0], workerParams[1], Double.parseDouble(workerParams[2]), Double.parseDouble(workerParams[3]));

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
