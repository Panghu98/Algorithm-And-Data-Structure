package tree;

public class Main {

    public static void main(String[] args) {

        Integer[] nums = {6,7,9,3,1,2};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);
    }
}
