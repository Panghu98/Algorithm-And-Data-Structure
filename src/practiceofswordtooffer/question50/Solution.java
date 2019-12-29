package practiceofswordtooffer.question50;

/**
 * @author dengg
 */
public class Solution {

    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() == 0) {
            return -1;
        }
        boolean[] count = new boolean[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++) {
            count[str.charAt(i)] = true;
        }


        for(int i=0; i < str.length();i++) {
            if(!count[str.charAt(i)]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.FirstNotRepeatingChar("googlae");
        System.err.println(result);
    }

}
