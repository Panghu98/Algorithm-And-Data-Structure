package test;

/**
 * @author panghu
 * @Title: DynamicDispatch
 * @ProjectName algorithm-data-structure
 * @Description: TODO
 * @date 19-8-9 上午10:18
 */
public class DynamicDispatch {

    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("Woman say hello");
        }
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("Man say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

}
