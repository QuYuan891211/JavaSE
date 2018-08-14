package Abstract;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {
    private double salary;
    private final Date hireDate;

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Employee(String name, double s, int year, int month, int day) {
        super(name);
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDate = calendar.getTime();

    }

    @Override
    String Discribtion() {
        return String.format("an employee with a salary if $%.2f",salary);
    }
}
