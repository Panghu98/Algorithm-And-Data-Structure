package leetcode;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 13:45 2021/3/13
 * @Modified By:
 */

public class MyHashSet {
    boolean[] set;

    public MyHashSet() {
        set = new boolean[16];
    }

    private int getUpperSize(int key) {
        int size = 1;
        while (size < key && size <= Integer.MAX_VALUE - 8) {
            size = size << 1;
        }

        return size;
    }

    public void add(int key) {
        if (key > set.length * 0.75) {
            int upperSize = getUpperSize(key);
            set = Arrays.copyOf(set, upperSize);
        }
        set[key] = true;
    }

    public void remove(int key) {
        if (key > set.length) {
            return;
        }
        set[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (key > set.length) {
            return false;
        }
        return set[key];
    }
}
