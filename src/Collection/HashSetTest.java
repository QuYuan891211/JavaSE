package Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashSetTest {
    public static void printSet(Set set){
       if(set !=null && !set.isEmpty()) {
           Iterator iterator = set.iterator();
           while (iterator.hasNext()){
               System.out.println(iterator.next());
           }
       }
    }
    public static void main(String[] a ){
        Set set = new HashSet();
        String[] target = {"abc","caoxi","ddd","abc"};
        for(String s:target){
            set.add(s);
        }
        printSet(set);
    }
}
