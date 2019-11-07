package practiceofswordtooffer.question2;

/**
 * 饿汉模式--线程安全
 *
 * 单例模式--构造函数私有化  只能在Class内部
 */
public class Singleton3 {

    private static Singleton3 instance;

    public static synchronized  Singleton3 getInstance(){
        //只有在示例为初始化时才进行初始化操作
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

    private Singleton3() {

    }
}