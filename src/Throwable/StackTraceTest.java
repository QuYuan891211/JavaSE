package Throwable;
import java.util.Scanner;

public class StackTraceTest {

    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        String target  = scanner.next();
        factorial(Integer.valueOf(target));
    }
    public static int factorial(int n){
        System.out.println("f : " + n);
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTraceElements = throwable.getStackTrace();
        for(StackTraceElement stackTraceElement: stackTraceElements){
            System.out.println(stackTraceElement);
        }
        int r;
        if(n==1){
            r= 1;
        }else {
            r= n*factorial(n-1);
        }
        System.out.println("return" + r);
        return r;
    }
}
