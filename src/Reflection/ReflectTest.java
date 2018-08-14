package Reflection;

import sun.reflect.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

//通过反射查询所输入类的信息
public class ReflectTest {
    public static void main(String[] a) throws ClassNotFoundException {
        //输入
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input class name: e.g. java util Date");
        name = scanner.next();

        Class clazz = Class.forName(name);
        printConstructor(clazz);
    }

    public static void printConstructor(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for(Constructor c:constructors){
            String name = c.getName();
            String modifier = Modifier.toString(c.getModifiers());
            if(modifier.length()>0){
                System.out.print(modifier + " ");
            }
            System.out.print(name + "(");
            Class[] paramTypes = c.getParameterTypes();
            for(int i=0;i<paramTypes.length;i++){
                String paramName = paramTypes[i].getName();
                System.out.print(paramName);
                if(i <paramTypes.length-1){System.out.print(",");}
            }
            System.out.print(")");

            System.out.println();
        }

    }
}
