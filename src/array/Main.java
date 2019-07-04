package array;

/**
 * @author panghu
 * @title: Main
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-2 下午4:42
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);
    }

}
