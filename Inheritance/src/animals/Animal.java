package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name){
        if(name.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name=name;
    }

    private void setAge(int age){
        this.age=age;
    }

    protected void setGender(String gender){
        if(name.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender=gender;
    }

    public String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.gender;
    }
}
