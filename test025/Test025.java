package test025;

/**
 * Created by cq on 2015/6/22.
 * 第25题：在字符串中找出连续最长的数字串，把这个串的长度返回。
 */
public class Test025 {
    public static int getLenOfMaxNumSubstring(String str){
        if (str == null){
            return 0;
        }

        int maxLen = 0, count = 0;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                count++;
            }
            else{
                if (count > maxLen){
                    maxLen = count;
                    //子字符串起始位置:i-count
                }
                count = 0;
            }
        }

        //若count较大，子字符串起始位置为str.length()-count
        return maxLen > count ? maxLen:count;
    }

    public static void main(String[] args){
        System.out.println(getLenOfMaxNumSubstring("123sss12345dse12345678"));
    }
}
