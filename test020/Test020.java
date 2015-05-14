package test020;

/**
 * Created by cq on 2015/5/14.
 * 第20题：输入一个表示整数的字符串，把该字符串转换成整数并输出。
 *        例如输入字符串“345”，则输出整数345。
 */
public class Test020 {
    //假设num表示的数在int的取值范围内
    public static int string2Int(String num){
        int nu = 0;
        for (int i=0; i<num.length(); i++){
            if (num.charAt(i) < '0' || num.charAt(i) > '9'){
                System.out.println("字符串中含有非数字字符。");
                break;
            }
            nu = nu*10 + (num.charAt(i)-'0');
        }
        return nu;
    }
    public static void main(String[] args){
        System.out.println(string2Int("123") == 123);
        System.out.println(string2Int("4291") == 4291);
    }
}
