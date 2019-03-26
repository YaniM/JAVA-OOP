package military;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void completeMission() {
        this.state = State.Finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
