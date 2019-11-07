package practiceofswordtooffer.question2;

/**
 * 饿汉模式--线程安全  但是在会造成内存的开销
 *
 * 单例模式--构造函数私有化  只能在Class内部
 */
@ThreadSafe
public class Singleton1 {

    private static Singleton1 singleton;

    /**
     * 获取示例
     * @return 实例化对象
     *
     *  注意 : 这里获取示例的方法必须是静态方法，因为在外部的调用无法直接实例化Singleton对象
     */
    public static Singleton1 getInstance(){
        return singleton;
    }

    private Singleton1() {

    }
}
