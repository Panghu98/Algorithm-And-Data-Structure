package test;

/**
 * 静态方法分派演示
 * @author panghu
 * @Title: StaticDispatch
 * @ProjectName algorithm-data-structure
 * @Description: TODO
 * @date 19-8-8 下午10:42
 */
public class StaticDispatch {

    static abstract class Human{

    }

    static class Woman extends Human{

    }

    static class Man extends Human{

    }

    public void sayHello(Human gay){
        System.out.println("Hello guy!");
    }

    public void sayHello(Woman gay){
        System.out.println("Hello lady!");
    }

    public void sayHello(Man gay){
        System.out.println("Hello gentleman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman=new Woman();
        StaticDispatch sr=new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }


}
