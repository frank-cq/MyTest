package test026;

/**
 * Created by cq on 2015/6/23.
 * 第26题：定义字符串的做旋转操作：把字符串前面的若干个字符移动到字符串的尾部。如
 *        把字符串abcdef左旋转2位得到字符串cdefab。请实现字符串左旋转的函数。要求
 *        对长度为n的字符串操作的时间复杂度为O(n)，辅助内存为O(1)。
 */
public class Test026 {
    //类似于第10题的翻转英文句子，只是将句子分为两个部分
    public static String rotateSentence(String sentence, int rotationNum){

        rotationNum = rotationNum % sentence.length();
        if (sentence == null || sentence.length() == 1 || rotationNum < 1){
            return null;
        }

        char[] charArray = sentence.trim().toCharArray();
        int arrLength = charArray.length;

        //翻转前半部分
        reverseCharArr(charArray,0,rotationNum-1);
        //翻转后半部分
        reverseCharArr(charArray,rotationNum,arrLength-1);
        //将整个字符串按字符首尾翻转
        reverseCharArr(charArray,0,arrLength-1);

        return String.valueOf(charArray);
    }
    //翻转字符数组中的一部分
    public static void reverseCharArr(char[] charArr, int head, int tail){
        while (head < tail){
            if (charArr[head] != charArr[tail]){
                charArr[head] ^= charArr[tail];
                charArr[tail] ^= charArr[head];
                charArr[head] ^= charArr[tail];
            }
            head++;
            tail--;
        }
    }

    public static void main(String[] args){
        System.out.println("将字符串 abcdef 左旋转2位后得："+rotateSentence("abcdef",2));
    }
}
