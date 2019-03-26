package animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    private void setGender(){
        super.setGender("Female");
    }

    public String produceSound(){
        return "Miau";
    }
}
