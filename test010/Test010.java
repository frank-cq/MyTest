package test010;

/**
 * Created by cq on 2015/4/6.
 * 第10题：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *        句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
 *        例如输入"I am a student."，则输出"student. a am I"。
 */
public class Test010 {
    public static String reverseSentence(String sentence){
        if (sentence == null){
            return null;
        }

        char[] charArray = sentence.trim().toCharArray();
        int arrLength = charArray.length;
        //第一次翻转，将整个字符串按字符首尾翻转
        reverseCharArr(charArray,0,arrLength-1);
        //针对单词再翻转一次，单词首尾恢复正常
        for (int head = 0, tail = 0;head < arrLength;tail++){
            if (charArray[tail] == ' ' || tail == arrLength-1){
                reverseCharArr(charArray,head,tail-1);
                head = tail+1;
            }
        }
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
        String testString = "I am a student.";
        System.out.println("转换前字符串为："+testString);
        System.out.println("转换后字符串为："+Test010.reverseSentence(testString));
    }
}
