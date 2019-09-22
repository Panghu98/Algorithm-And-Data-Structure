package test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    private static final AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        //设置柯南的年龄为10岁
        User conan = new User("conan",10);
        //柯南长了一岁，但是仍然会输出旧的年龄
        System.out.println(updater.getAndIncrement(conan));
        //输出柯南现在的年龄
        System.out.println(updater.get(conan));
    }


    public static class User {
        private String name;
        public volatile int old;
        public User(String name,int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }
}

