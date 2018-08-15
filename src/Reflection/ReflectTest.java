package Reflection;

import sun.reflect.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        String modifier = Modifier.toString(clazz.getModifiers());
        if(modifier != null && modifier.length()>0){System.out.print(modifier + " ");}
        System.out.print("class " + clazz.getSimpleName());
        System.out.println();
        printConstructor(clazz);
        printField(clazz);
        printMethod(clazz);
    }
    //获取所以构造器
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
                String paramName = paramTypes[i].getSimpleName();
                System.out.print(paramName);
                if(i <paramTypes.length-1){System.out.print(",");}
            }
            System.out.print(")");

            System.out.println();
        }

    }
    //获取所有域
    public static void printField(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for(int i = 0;i<fields.length;i++){
            String modifier = Modifier.toString(fields[i].getModifiers());
            System.out.print(modifier + " ");
            String fieldName =  fields[i].getType().getSimpleName();
            System.out.print(fieldName + " " + fields[i].getName() + ";");
            System.out.println();
        }

    }
    public static void printMethod(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for(int i=0;i<methods.length;i++){
            String modifier = Modifier.toString(methods[i].getModifiers());
            System.out.print(modifier + " ");
            String clazzName = methods[i].getReturnType().getSimpleName();
            System.out.print(clazzName + " ");
            System.out.print(methods[i].getName()+"(");
            Class[] classes = methods[i].getParameterTypes();
            for(int j = 0;j<classes.length;j++){
                System.out.print(classes[j].getSimpleName());
                if(j<classes.length-1){System.out.print(",");}
            }
            System.out.print(");");
            System.out.println();
        }

    }
}
