package first;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();

        while (true){
            String[] inputParams = scanner.nextLine().split("\\s+");

            if(inputParams[0].equals("End")){
                break;
            }else if(inputParams[0].equals("Citizen")){
                Citizen citizen = new Citizen(inputParams[1],Integer.parseInt(inputParams[2]),inputParams[3],inputParams[4]);
                birthables.add(citizen);
            }else if(inputParams[0].equals("Pet")){
                Pet pet = new Pet(inputParams[1],inputParams[2]);
                birthables.add(pet);
            }

        }

        String  year = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
