package military;

public class SpecialisedSoldierImpl extends PrivateImpl implements ISpecialised {
    private Corp corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Corps: " + this.corps.toString();
    }
}
