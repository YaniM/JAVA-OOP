package military;

import java.util.*;

public class LeutenantImpl extends PrivateImpl implements ILeutenant {
    private Set<PrivateImpl> privates;

    public LeutenantImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>((o1, o2) -> o2.getId() - o1.getId());
    }

    @Override
    public void addPrivate(PrivateImpl priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Privates:");

        for (PrivateImpl priv : this.privates) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(priv.toString());
        }

        return sb.toString();
    }
}
