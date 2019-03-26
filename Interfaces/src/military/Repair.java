package military;

public class Repair {
    private String partName;
    private int hoursWorked;

    public Repair(String name, int hoursWorked) {
        this.partName = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}
