package Array;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] a){
        int[] target = {4,5,6,4,4,5,5,5,3,5,5,7,5,3,5};
        System.out.println(find(target));
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
    }

    //打印方法


