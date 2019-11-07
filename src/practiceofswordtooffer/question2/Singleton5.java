package practiceofswordtooffer.question2;

@ThreadSafe
public class Singleton5 {

    /**
     * 私有构造函数
     */
    private Singleton5(){

    }

    /**
     * 单例对象    注意这里是和双重检查锁最大的不同 就是加了volatile关键字  ，禁止重排序操作
     */
    private static volatile Singleton5 instance = null;

    public static Singleton5 getInstance() {
        if (instance == null) {
            //同步锁  B-2  B线程可能在没有完成instance对象初始化之前就被返回了  也就是A中的instance没有初始化
            synchronized (Singleton5.class) {
                //A -3
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
