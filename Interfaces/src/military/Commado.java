package military;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Commado extends SpecialisedSoldierImpl implements ICommado {

    private Set<Mission> missions;

    public Commado(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Missions:");

        this.missions.forEach(mission -> {
            sb.append(System.lineSeparator());
            sb.append("  ").append(mission.toString());
        });

        return sb.toString();
    }
}
