package leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 13:40 2021/1/18
 * @Modified By:
 */
public class Leetcode721 {


    // 邮箱 -> 全部信息
    Map<String,List<String>> accountsMap = new HashMap<>(16);

    // 全部信息 -> 邮箱列表
    Map<List<String>,List<String>> accountListMap = new HashMap<>(16);

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // 验证账号是否相同
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            buildAccount(account);
        }

        accountListMap.keySet().stream().map(item -> {
            // todo 收集信息
            return null;
        }).collect(Collectors.toCollection(ConcurrentLinkedDeque::new));

        return null;
    }




    /**
     *
     * @param allInfo
     * @return 是否进行了合并
     */
    private void buildAccount(List<String> allInfo) {
        List<String> mailList = new ArrayList<>(allInfo);
        // 邮箱列表
        mailList.remove(0);
        for (int i = 0; i < mailList.size(); i++) {
            String item = mailList.get(i);
            List<String> anotherAllInfo = accountsMap.get(item);
            if (anotherAllInfo != null) {
                mergeAccount(allInfo,anotherAllInfo);
                accountListMap.remove(allInfo);
            }else {
                accountsMap.put(item,allInfo);
                accountListMap.put(allInfo,mailList);
            }
        }
    }

    /**
     * 合并两个账号的账号信息
     * @return 合并后的用于账号信息列表
     */
    private void mergeAccount(List<String> originalAccounts,List<String> anotherAccount) {

        ArrayList<String> allInfo = new ArrayList<>(originalAccounts);
        // 用于去重
        HashSet<String> accounts = new HashSet<>();
        // 数组的第一个元素是用户名
        for (int i = 1; i < originalAccounts.size(); i++) {
            accounts.add(originalAccounts.get(i));
        }


        for (int i = 1; i < anotherAccount.size(); i++) {
            String key = anotherAccount.get(i);
            if ( !accounts.contains(key)) {
                originalAccounts.add(key);
                // 如果一个List当中不存在重复的邮箱，则不需要下面这一步
                accounts.add(key);
            }
        }

        accountListMap.put(allInfo,originalAccounts);

    }

}
