package Collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] a){
        PriorityQueue<GregorianCalendar> p = new PriorityQueue();
        p.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        p.add(new GregorianCalendar(1984, Calendar.APRIL,21));
        p.add(new GregorianCalendar(1966, Calendar.DECEMBER,16));
        p.add(new GregorianCalendar(2561, Calendar.AUGUST,15));
        p.add(new GregorianCalendar(2106, Calendar.FEBRUARY,3));
        System.out.println("Iterating over elements");
        for(GregorianCalendar gregorianCalendar:p){
            System.out.println(gregorianCalendar.get(Calendar.YEAR));
        }
        System.out.println("Removing elements");
        while (!p.isEmpty()) {
            System.out.println(p.remove().get(Calendar.YEAR));
        }
    }
}
