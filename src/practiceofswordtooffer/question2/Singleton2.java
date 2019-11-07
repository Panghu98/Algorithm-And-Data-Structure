package practiceofswordtooffer.question2;

/**
 *  懒汉模式 -- 线程不安全
 *  单例示例在第一次使用的时候进行创建
 */
@NotThreadSafe
public class Singleton2 {

    /**
     * 私有构造函数
     */
    private Singleton2(){

    }


    private static Singleton2 instance = null;

    public static  Singleton2 getInstance(){
        //只有在示例为初始化时才进行初始化操作
        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
