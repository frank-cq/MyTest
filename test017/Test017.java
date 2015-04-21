package test017;

/**
 * Created by cq on 2015/4/21.
 * 第17题：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 */
public class Test017 {
    public static void getFirstAppearOnceChar(String s){
        if (s == null){
            return;
        }

        SpecifiedInteger[] temp = new SpecifiedInteger[255];
        for (int i = 0; i < 255; i++){
            temp[i] = new SpecifiedInteger();
        }

        char[] charArray = s.trim().toCharArray();
        int index = 0;

        //记录字符串中每个字符出现的次数
        for (char c:charArray){
            temp[c].setFreq(temp[c].getFreq()+1);
            temp[c].setIndex(index++);
        }

        //firstSingleChar赋初值为字符串的第一个字符，若第一个字符不只出现一次，则将其位置信息标为MAX_VALUE
        int firstSingleChar = charArray[0];
        if (temp[firstSingleChar].getFreq() != 1){
            temp[firstSingleChar].setIndex(Integer.MAX_VALUE);
        }
        //遍历255个位置，搜索第一个只出现一次的字符
        for (int i = 0; i < 255; i++){
            if (temp[i].getFreq() == 1 && temp[i].getIndex() < temp[firstSingleChar].getIndex()){
                firstSingleChar = i;
            }
        }

        System.out.println((char)firstSingleChar);
    }
    public static void main(String[] args){
        getFirstAppearOnceChar("adkffagddk");

        getFirstAppearOnceChar("abaccdeff");


    }
}
