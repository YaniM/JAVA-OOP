package animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    private void setGender() {
        super.setGender("Male");
    }

    public String produceSound() {
        return "Give me one million b***h";
    }
}
