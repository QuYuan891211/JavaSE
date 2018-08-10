package Array;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] a){
        int[] target = {4,5,6,4,4,5,5,5,3,5,5,7,5,3,5};
        //System.out.println(find(target));
        josephProblem();
    }
//1.找到数组中的支配者[出现率大于0.5],如果没有，则返回-1（方法：额外开辟空间存储已查过的数）
    public static int find(int[] target) {
        if (target == null || target.length < 1) {
            return -1;
        }
        //存放已经查找过的
        Map map = new HashMap();
        for (int i = 0; i < target.length; i++) {
            System.out.println(map);
            if (map.containsKey(target[i])) {
                continue;
            }
            double proportion;
            double sum = 0;
            for (int j = i; j < target.length; j++) {
                if (target[i] == target[j]) {
                    sum++;
                }
            }
            proportion = sum / 15;
            if (proportion > 0.5) {
                return target[i];
            }
            map.put(target[i], proportion);
        }
        return -1;
    }
    //2.约瑟环问题（数组的方式---被提出的人也参与报数）
    public static void josephProblem(){
        Boolean[] cycle = new Boolean[30];
        for(int i=0;i<cycle.length;i++){
            cycle[i] = true;
        }
        System.out.println("此时数组：" + Arrays.toString(cycle) );
        int leftPerson = cycle.length;
        //下一次循环的起始索引
        int index = 0;
        //记录步数
        int count = 0;
        while (leftPerson > 15){
            count++;
            if(count==9){
                if(cycle[index]){
                    cycle[index]=false;
                    leftPerson --;
                    count = 0;
                    System.out.println("排除出第" + index + "人");
                    System.out.println("此时数组：" + Arrays.toString(cycle) );
                }else {
                    count--;
                }
            }
            index++;
            if(index==cycle.length){index=0;}
        }
    }
}

    //打印方法


