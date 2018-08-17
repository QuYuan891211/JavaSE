package Abstract;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person implements Cloneable {
    private double salary;

    public void setHireDate(int year,int month,int day) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year,month-1,day);
        this.hireDate = gregorianCalendar.getTime();
    }

    private Date hireDate;

    public double getSalary() {
        return salary;
    }

    public Employee clone() throws CloneNotSupportedException {
        //Employee newEmp = this.clone(); 错误，变成了递归
        Employee newEmp = (Employee) super.clone();
        newEmp.hireDate = (Date) this.hireDate.clone();
        return newEmp;
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

    public static void main(String[] a) throws CloneNotSupportedException {
        Employee oldEmp = new Employee("qy", 99.9, 2015,7, 15);
        Employee newEmp = oldEmp.clone();
        newEmp.setHireDate(2000,2,3);

        System.out.println(oldEmp);
        System.out.println(newEmp);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
