package test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 22:15 2020/5/15
 * @Modified By:
 */
public class StaticClassTest {

    static class StaticTestClass{

        private Integer hello;

        static Object object = new Object();

        @Override
        public int hashCode() {
            return object.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }

        public StaticTestClass() {
        }
    }




    public static void main(String[] args) {
        StaticTestClass staticClassTest = new StaticTestClass();
        System.out.println(staticClassTest.hashCode());

        StaticTestClass staticClassTest2 = new StaticTestClass();
        System.err.println(staticClassTest2.hashCode());

        System.err.println(staticClassTest == staticClassTest2);
        System.err.println(staticClassTest.equals(staticClassTest2));
    }

}
