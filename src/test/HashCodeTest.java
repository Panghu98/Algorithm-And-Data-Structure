package test;

import java.util.HashMap;
import java.util.HashSet;

public class HashCodeTest {


    public static void main(String[] args) {
        Double d = new Double(100.1);
        System.out.println(d.hashCode());

        String str = "hello";
        System.out.println(str.hashCode());

        Student student = new Student(1L,"胖虎");
        System.out.println(student.hashCode());

        Student student2 = student;
        Student student1 = new Student(1L,"胖虎");
        System.err.println(student1.hashCode());

    }

}
