package Reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopyTest {
    public static Object[] badCopyof(Object[] a,int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }
    public static Object goodCopyof(Object a,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()){return null;}
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

    public static void main(String[] a){
        int[] target = {1,2,4,5,67,2};
        int[] b = (int[]) goodCopyof(target,10);
        System.out.println(Arrays.toString(b));

        String[] target2 = {"ddd","cqn","lyt","js"};
        String[] b2 = (String[]) goodCopyof(target2,10);
        System.out.println(Arrays.toString(b2));

        //the following call will generate an exception
        String[] b3 = (String[]) badCopyof(target2,10);
    }
}
