package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeTest {

    public static void main(String[] a){
        printTable(1,10,10,square);
    }
    public static double square(double x){
        return x*x;
    }
    public static void printTable(double from, double to, int n, Method a) throws InvocationTargetException, IllegalAccessException {
        double dx = (to-from)/(n-1);
        for(double x = from;x<=to;x+=dx){
            double result = (Double)a.invoke(null,x);
            System.out.println(x + "  " + result);
        }

    }
}
