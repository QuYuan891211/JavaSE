package String;

public class Test {
    public static void main(String[] a){
        subStringByChar("a中国abc是",9);
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
}
