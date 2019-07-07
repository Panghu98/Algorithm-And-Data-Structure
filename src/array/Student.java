package array;

/**
 * @author panghu
 * @title: Student
 * @projectName Algorithm_And_Data_Structure
 * @date 19-7-4 下午4:25
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s,score : %d)",name,score );
    }


    public static void main(String[] args) {

        Array<Student> array = new Array<>();
        array.addLast(new Student("Alice",100));
        array.addLast(new Student("Bob",66));
        array.addLast(new Student("Charlie",88));
        System.out.println(array);
    }
}
