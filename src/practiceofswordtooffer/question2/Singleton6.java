package practiceofswordtooffer.question2;

/**
 * @author panghu
 * @Title: SingletonExample2
 * @Description: TODO
 * @date 19-2-17 下午3:08
 */

/**
 * 饿汉 模式
 * 单例实例在类装载的时候进行创建
 * 会造成资源的浪费
 *
 * @author panghu
 */
@ThreadSafe
public class Singleton6 {

    private Singleton6() {
    }

    private static Singleton6 instance = null;

    /**
     * 通过静态代码块实例化对象
     * 注意静态代码块的防止位置
     */
    static {
        instance = new Singleton6();
    }


    public static Singleton6 getInstance() {
        return instance;
    }

}
