package Abstract;

public abstract class Person {
    public String getName() {
        return name;
    }
    public Person(String name){
        this.name = name;
    }
    private String  name;
    abstract String Discribtion();
}
