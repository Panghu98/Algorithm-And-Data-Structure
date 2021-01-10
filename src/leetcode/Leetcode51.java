package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 14:25 2021/1/10
 * @Modified By:
 */
public class Leetcode51 {

    private List<List<String>> solutions = new ArrayList<>();

    private final static char queen = 'Q';

    private final static char blank = '.';


    public List<List<String>> solveNQueens(int n) {
        LinkedList<String> solution = new LinkedList<>();
        getSolution(n,solution);
        return solutions;
    }
    
    private void getSolution(int n,LinkedList<String> solution) {
        if (solution.size() == n) {
            solutions.add(new LinkedList<>(solution));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(solution,i)) {
                String s = buildString(i, n);
                solution.add(s);
                getSolution(n, solution);
                solution.removeLast();
            }
        }
        
    }

    /**
     * 构建皇后字符串
     * @param n
     * @param length
     * @return
     */
    private String buildString(int n,int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == n) {
                stringBuilder.append(queen);
            }else {
                stringBuilder.append(blank);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 验证位置是否可用
     * @param path
     * @param n
     * @return
     */
    private boolean isValid(List<String> path,int n) {
        for (int i = 0; i < path.size(); i++) {
            String str = path.get(i);
            if (str.charAt(n) == queen) {
                return false;
            }
        }

        // todo ,判定不能在一条斜线上
        return true;
    }


    @Test
    public void test() {
        List<List<String>> x = solveNQueens(3);
        x.forEach(System.out::println);
    }

}
