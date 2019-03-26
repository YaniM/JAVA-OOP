package first;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] inputParams = scanner.nextLine().split("\\s+");

            if(inputParams.length==4){
                Citizen citizen = new Citizen(inputParams[0],Integer.parseInt(inputParams[1]),inputParams[2],inputParams[3]);
                personList.add(citizen);
            }else if(inputParams.length==3){
                Rebel rebel = new Rebel(inputParams[0],Integer.parseInt(inputParams[1]),inputParams[2]);
                personList.add(rebel);
            }
        }

        int foodCount = 0;

        while (true) {
            String name = scanner.nextLine();

            if(name.endsWith("End")){
                break;
            }

            for (Person person : personList) {
                if(person.getName().equals(name)){
                    person.buyFood();
                }
            }
        }

        for (Person person : personList) {
            foodCount+=person.getFood();
        }

        System.out.println(foodCount);

    }
}
