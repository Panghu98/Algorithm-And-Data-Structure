package practiceofswordtooffer.question19;

public class Solution {

    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, pattern,0,0);
    }

    private boolean matchCore(char[] str, char[] pattern,int indexOfStr,int indexOfPattern) {
        if (str[indexOfStr] == '\0' && pattern[indexOfPattern] == '\0') {
            return true;
        }
        if (str[indexOfStr] != '\0' && pattern[indexOfPattern] == '\0') {
            return false;
        }
        if (pattern[indexOfPattern+1] == '*') {
            if (pattern[indexOfPattern] == str[indexOfStr] || (pattern[indexOfPattern] == '.' || str[indexOfStr] != '\0')) {
                return matchCore(str, pattern, indexOfStr+1, (indexOfPattern+2))
                        || matchCore(str, pattern, indexOfStr+1, indexOfPattern)
                        || matchCore(str, pattern, indexOfStr, indexOfPattern+2);
            }else {
                return matchCore(str, pattern, indexOfStr, indexOfPattern+2);
            }
        }

        if (str[indexOfStr] == str[indexOfPattern] || pattern[indexOfPattern] == '.' && str[indexOfStr] != '\0') {
            return matchCore(str, pattern, indexOfStr+1, indexOfPattern+1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] str = {'a','a','a'};
        char[] pattern = {'a','b','*','a','*','a'};
        boolean result = solution.match(str,pattern);
        System.err.println(pattern);
    }

}
