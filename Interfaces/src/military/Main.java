package military;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<ISoldier> soldiers = new ArrayList<>();

        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens[0].equals("End")) {
                break;
            }

            if (tokens[0].equals("Private")) {
                PrivateImpl privSoldied = new PrivateImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                soldiers.add(privSoldied);
            } else if (tokens[0].equals("LeutenantGeneral")) {
                LeutenantImpl leutenant = new LeutenantImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));

                for (int i = 5; i <= tokens.length - 1; i++) {

                    for (ISoldier soldier : soldiers) {
                        if (soldier.getId() == Integer.parseInt(tokens[i])) {
                            leutenant.addPrivate((PrivateImpl) soldier);
                        }
                    }
                }
                soldiers.add(leutenant);
            } else if (tokens[0].equals("Engineer")) {
                if (tokens[5].equals("Airforces") || tokens[5].equals("Marines")) {
                    Corp corp = Corp.valueOf(tokens[5]);
                    Engineer engineer = new Engineer(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), corp);

                    for (int i = 6; i <= tokens.length - 1; i += 2) {
                        Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                        engineer.addRepair(repair);
                    }
                    soldiers.add(engineer);
                }
            } else if (tokens[0].equals("Commando")) {
                if (tokens[5].equals("Airforces") || tokens[5].equals("Marines")) {
                    Corp corp = Corp.valueOf(tokens[5]);
                    Commado commado = new Commado(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), corp);

                    for (int i = 6; i <= tokens.length - 1; i += 2) {
                        if (tokens[i + 1].equals("Finished") || tokens[i + 1].equals("inProgress")) {
                            State state = State.valueOf(tokens[i + 1]);
                            Mission mission = new Mission(tokens[i], state);
                            commado.addMission(mission);
                        }
                    }
                    soldiers.add(commado);
                }
            } else if (tokens[0].equals("Spy")) {
                Spy spy = new Spy(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
                soldiers.add(spy);
            }
        }

        for (ISoldier soldier : soldiers) {
            System.out.println(soldier);
        }
    }
}
