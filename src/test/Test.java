package test;

import java.util.*;

/**
 * @author panghu
 * @title: Test
 * @projectName Algorithm_And_Data_Structure
 * @date 19-6-29 下午7:38
 */
public class Test{


    private String[] words = ("And that is how" + "we know the earth to be banana-shaped  .").split(" ");

    //接口实例化
    public Iterator<String> iterator(){
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>(10);
    }

    class Demo<T>{

        public Demo(T number) {
            System.out.print(" " + number);

        }
    }

}
