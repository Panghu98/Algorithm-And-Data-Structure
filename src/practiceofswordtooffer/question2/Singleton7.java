package practiceofswordtooffer.question2;


/**
 * @author panghu
 * @Title: Singleton7
 * @Description: TODO
 */

/**
 * 枚举模式：最安全
 */
@ThreadSafe
public class Singleton7 {

    private Singleton7() {

    }

    public static Singleton7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        /***/
        INSTANCE;

        private Singleton7 singleton;

        /**
         * JVM保证该方法绝对只会被调用一次
         */
        Singleton() {
            singleton = new Singleton7();
        }

        public Singleton7 getSingleton() {
            return singleton;
        }

    }

}
