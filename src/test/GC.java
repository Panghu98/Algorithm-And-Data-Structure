package test;

/**
 * @author panghu
 * @Title: GC
 * @ProjectName algorithm-data-structure
 * @Description: TODO
 * @date 19-8-8 上午10:40
 */
public class GC {

    public final void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        byte[] placeOrder = new byte[64*1024*1024];
        System.gc();
    }

}
