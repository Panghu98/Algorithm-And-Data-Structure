package test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 21:03 2020/5/26
 * @Modified By:
 */
public class StringTestMain {
    public static void main(String[] args) {
        String s = "14 .1.28";
        String[] strings = s.split("\\.");
        for (String string : strings) {
            System.err.println(string);
        }
    }
}
