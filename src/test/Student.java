package test;

public class Student {

    private Long id;

    private String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public int hashCode(){

        int B = 31;
        int hash = 0;
        hash = hash * B + id.hashCode();
        hash = hash * B + name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return id.equals(student.id) &&
                name.equals(student.name);
    }
}
