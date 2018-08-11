package String;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] a) throws UnsupportedEncodingException {
        //subStringByChar("a中国abc是",9);
        //test();
        String[] test = {"Bc","Ad","ac","Hello","HA","X man","little","During","day"};
        //sortString(test);
        subString("我打，dd中国gg人",6);
    }
    //1.编写一个字符串截取方法，要求按照字节进行截取，截取一个字节数组形式的字符串，其中包含中英文。如果最后截取到半个中文字符，则舍弃。
    public static byte[] subStringByChar(String inputString,int index){
        byte[] target = inputString.getBytes();
        System.out.println("长度 : " + target.length);
        for(byte  a:target){
            System.out.println(a);
        }

        System.out.println(new String(target,0,index));

        return target;
    }

    public static void test(){
        /**
         * 情景一：字符串池
         * JAVA虚拟机(JVM)中存在着一个字符串池，其中保存着很多String对象;
         * 并且可以被共享使用，因此它提高了效率。
         * 由于String类是final的，它的值一经创建就不可改变。
         * 字符串池由String类维护，我们可以调用intern()方法来访问字符串池。
         */
        String s1 = "abc";
        //↑ 在字符串池创建了一个对象
        String s2 = "abc";
        //↑ 字符串pool已经存在对象“abc”(共享),所以创建0个对象，累计创建一个对象
        System.out.println("s1 == s2 : "+(s1==s2));
        //↑ true 指向同一个对象，
        System.out.println("s1.equals(s2) : " + (s1.equals(s2)));
        //↑ true  值相等
        //↑------------------------------------------------------over
        /**
         * 情景二：关于new String("")
         *
         */
        String s3 = new String("abc");
        //↑ 创建了两个对象，一个存放在字符串池中，一个存在与堆区中；
        //↑ 还有一个对象引用s3存放在栈中
        String s4 = new String("abc");
        //↑ 字符串池中已经存在“abc”对象，所以只在堆中创建了一个对象
        System.out.println("s3 == s4 : "+(s3==s4));
        //↑false   s3和s4栈区的地址不同，指向堆区的不同地址；
        System.out.println("s3.equals(s4) : "+(s3.equals(s4)));
        //↑true  s3和s4的值相同
        System.out.println("s1 == s3 : "+(s1==s3));
        //↑false 存放的地区多不同，一个栈区，一个堆区
        System.out.println("s1.equals(s3) : "+(s1.equals(s3)));
        //↑true  值相同
        //↑------------------------------------------------------over
        /**
         * 情景三：
         * 由于常量的值在编译的时候就被确定(优化)了。
         * 在这里，"ab"和"cd"都是常量，因此变量str3的值在编译时就可以确定。
         * 这行代码编译后的效果等同于： String str3 = "abcd";
         */
        String str1 = "ab" + "cd";  //1个对象
        String str11 = "abcd";
        System.out.println("str1 = str11 : "+ (str1 == str11));
        //↑------------------------------------------------------over
        /**
         * 情景四：
         * 局部变量str2,str3存储的是存储两个拘留字符串对象(intern字符串对象)的地址。
         *
         * 第三行代码原理(str2+str3)：
         * 运行期JVM首先会在堆中创建一个StringBuilder类，
         * 同时用str2指向的拘留字符串对象完成初始化，
         * 然后调用append方法完成对str3所指向的拘留字符串的合并，
         * 接着调用StringBuilder的toString()方法在堆中创建一个String对象，
         * 最后将刚生成的String对象的堆地址存放在局部变量str3中。
         *
         * 而str5存储的是字符串池中"abcd"所对应的拘留字符串对象的地址。
         * str4与str5地址当然不一样了。
         *
         * 内存中实际上有五个字符串对象：
         *       三个拘留字符串对象、一个String对象和一个StringBuilder对象。
         */
        String str2 = "ab";  //1个对象
        String str3 = "cd";  //1个对象
        String str4 = str2+str3;
        String str5 = "abcd";
        System.out.println("str4 = str5 : " + (str4==str5)); // false
        //↑------------------------------------------------------over
        /**
         * 情景五：
         *  JAVA编译器对string + 基本类型/常量 是当成常量表达式直接求值来优化的。
         *  运行期的两个string相加，会产生新的对象的，存储在堆(heap)中
         */
        String str6 = "b";
        String str7 = "a" + str6;
        String str67 = "ab";
        System.out.println("str7 = str67 : "+ (str7 == str67));
        //↑str6为变量，在运行期才会被解析。
        final String str8 = "b";
        String str9 = "a" + str8;
        String str89 = "ab";
        System.out.println("str9 = str89 : "+ (str9 == str89));
        //↑str8为常量变量，编译期会被优化
        //↑------------------------------------------------------over
    }
    //3.将给定的字符串按照首字母（大写在小写之前）排序，不能使用现有的类
    public static void sortString(String[] target){
        for(int i = 0;i<target.length;i++){
            for(int j = target.length-1;j>i;j--){
                if(stringCmp(target[j] , target[j-1]) < 0){
                    String temp = target[j];
                    target[j] = target[j-1];
                    target[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(target));
    }
    public static int stringCmp(String a,String b){
        char[] a_char = a.toCharArray();
        char[] b_char = b.toCharArray();
        int length = Math.min(a_char.length,b_char.length);
        int finalResult = 0;
        for(int i = 0;i < length;i++){
            byte temp1 = (byte)a_char[i];
            byte temp2 = (byte)b_char[i];
            int result1 = temp1>96?temp1-96:temp1-64;
            int result2 = temp2>96?temp2-96:temp2-64;
            if(result1 != result2) {
                finalResult = result1 - result2;
                break;
            }else {
                finalResult = a_char[i]-b_char[i];
                if(finalResult!=0){break;}
            }
        }
        return finalResult;
    }
    //4.截取字符串函数，按照字节截取，但中文不能被截取为半个
    public static String subString(String target,int byteNumber) throws UnsupportedEncodingException {
        if(byteNumber == 0){return "";}
        if(byteNumber > target.getBytes().length){return target; }
        StringBuffer stringBuffer = new StringBuffer();
        //target = new String(target.getBytes(),"GBK");
        char[] aa = new char[80];
        if(byteNumber%2==0){
            for (int i = 0; i < byteNumber/2;i++){
                char c  = target.charAt(i);
                aa[i] = c;
            }
        }
        for(int i=0;i<byteNumber;i++){

        }
        System.out.println(Arrays.toString(aa));


        return "";

    }
    //判断是否为中文
    public static boolean isChinese(char a) throws UnsupportedEncodingException {
        return String.valueOf(a).getBytes("GBK").length>1;
    }
}
