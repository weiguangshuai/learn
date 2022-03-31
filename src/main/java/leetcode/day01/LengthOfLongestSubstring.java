package leetcode.day01;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("dvdf");
        System.out.println(i);
    }

    //两个指针移动，左边的指针负责起始位置，右边的指针一直移动，遇到重复的就把左边的指针往前移动一位
    public static int lengthOfLongestSubstring(String s) {
        int sum = 0;
        //哈希集合，记录是否出现过
        Set<Character> occ = new HashSet<>();
        int rk = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while ((rk + 1) < s.length() && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            sum = Math.max(sum, rk - i + 1);
        }

        return sum;
    }
}