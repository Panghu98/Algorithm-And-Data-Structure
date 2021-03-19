package test;

/**
 * @author: panghu
 * @Description:
 * @Date: Created in 15:54 2021/3/18
 * @Modified By:
 */

public class OutClass {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public static class  InnerClass{
        private String a;

        public InnerClass(String a) {
            this.a = a;
        }
    }

}
