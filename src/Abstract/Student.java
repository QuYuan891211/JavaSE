package Abstract;

public class Student extends Person{


    private String major;
    public Student(String major,String name){
        super(name);
        this.major = major;
    }
    @Override
    String Discribtion() {
        return "a student majoring in" + major;
    }
    public String getMajor() {
        return major;
    }
}
