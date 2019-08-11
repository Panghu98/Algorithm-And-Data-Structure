package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目描述:
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author panghu
 * @Title: Solution139
 * @ProjectName algorithm-data-structure
 * @Description: TODO
 * @date 19-8-10 上午11:44
 */
public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s,new HashSet<>(wordDict),0,new Boolean[s.length()]);
    }

    //转换为结合,对于无序查找的效率更高
    public boolean word_Break(String s, Set<String> wordDict,int start,Boolean[] mem){
        if (start == s.length()){
            return true;
        }

        if (mem[start] != null){
            return mem[start];
        }
        //等号是为了判断结束
        for (int end = start+1; end <= s.length(); end++) {
            //不为真  end++
            //进行一次减操作之后,建立一个新的String,String的开始就是原String的结束
            if (wordDict.contains(s.substring(start,end)) && word_Break(s, wordDict, end, mem)){
                return mem[start]=true;
            }
        }
        return mem[start] = false;
    }
}
