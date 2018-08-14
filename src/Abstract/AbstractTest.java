package Abstract;

public class AbstractTest {
    public static void main(String[] a){
        Person[] people = new Person[10];
        people[0] = new Employee("caoxi",22.2,2014,5,5);
        people[1] = new Student("math","ddd");
        for(Person p:people){
            System.out.println(p.getName() + "," + p.Discribtion());
        }
    }
}
