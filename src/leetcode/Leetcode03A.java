package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 18:59 2021/3/16
 * @Modified By:
 */
public class Leetcode03A {


    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }


        int start = 0;
        int end = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);

            for (int j = start; j <= end && j < i; j++) {
                if (s.charAt(j) == item) {
                    start = j + 1;
                    break;
                }
            }

            end = i;

            maxLength = Math.max(end - start + 1,maxLength);
        }

        return maxLength;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
    }

    public static void main(String[] args) {

    }


    static class Person {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }


    static class Student {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

}
