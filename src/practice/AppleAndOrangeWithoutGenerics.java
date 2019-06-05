package practice;

import java.util.ArrayList;

/**
 * @author panghu
 * @title: AppleAndOrangeWithoutGenerics
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-2 下午4:11
 */

class Apple{
    private static long counter;
    private final long  id  = counter++;
    public  long id(){
        return id;
    }
}

class Orange{

}

/**
 * @author panghu
 */
public class AppleAndOrangeWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
             apples.add(new Apple());
        }

        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            long id = ((Apple)apples.get(i)).id();
            System.out.println(id+" ");
        }
    }

}
