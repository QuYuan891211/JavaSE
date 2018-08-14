package Abstract;

public class AbstractTest {
    public static void main(String[] a){
        Person[] people = new Person[10];
        Employee e1 =  new Employee("caoxi",22.2,2014,5,5);
        Employee e2 =  new Employee("caoxi",22.2,2014,5,5);
        System.out.println(e1.equals(e2));//false， 实例变量的引用不同（两个对象在堆内存的地址不是同一个）
        people[0] =e1;
        people[1] = new Student("math","ddd");
        for(Person p:people){
            System.out.println(p.getName() + "," + p.Discribtion());
        }
    }
}
