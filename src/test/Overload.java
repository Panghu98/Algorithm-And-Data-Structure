package test;

import java.io.Serializable;

/**
 * @author panghu
 * @Title: Overload
 * @ProjectName algorithm-data-structure
 * @Description: TODO
 * @date 19-8-9 上午9:45
 */
public class Overload {

    public static void sayHello(Object arg){
        System.out.println("Hello Object");
    }

    public static void sayHello(long arg){
        System.out.println("Hello long");
    }

    public static void sayHello(int arg){
        System.out.println("Hello int");
    }

    public static void sayHello(Character arg){
        System.out.println("Hello Character");
    }

    public static void sayHello(char... arg){
        System.out.println("Hello char...");
    }

    public static void sayHello(char arg){
        System.out.println("Hello char");
    }

    public static void sayHello(Serializable arg){
        System.out.println("Hello Serializable");
    }

    public static void main(String[] args) {
        sayHello();
    }

}
