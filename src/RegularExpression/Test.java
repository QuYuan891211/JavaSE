package RegularExpression;

public class Test {

    public static void main(String [] a){
        String number = findNumber("safg7sad0ag09asd7969aad");
        System.out.println(number);
        String number2 = findNumber("2006-04-15 02:31:04");
        System.out.println(number2);
    }
    //1.将其中的数字找出
    public static String findNumber(String target){
        String regex = "[^0-9]";
        String number = target.replaceAll(regex,"");
        return number;
    }
    //2.去掉所有特殊符号
    public static String removeSymbols(String target){
        String regex = "\\D";
        String[] result = target.split(regex);
        String number = "";
        for(String a:result){
            number += a;
        }
        return number;
    }
}
