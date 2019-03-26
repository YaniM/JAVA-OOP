package military;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Engineer extends SpecialisedSoldierImpl implements IEngineer {
    private Set<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Repairs:");

        this.repairs.forEach(repair -> {
            sb.append(System.lineSeparator());
            sb.append("  ").append(repair.toString());
        });

        return sb.toString();
    }
}
