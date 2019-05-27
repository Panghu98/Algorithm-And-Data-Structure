package test;

/**
 * @author panghu
 * @title: Student
 * @projectName Algorithm_And_Data_Structure
 * @date 19-5-27 上午8:43
 */
public class Student {

    private String name;

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static  void sing() {
        System.out.println("I just want to sing....");
    }

    public static String sing(String songName){
        System.out.println("What I am singing is the song "+songName);
        return songName;
    }

    public void selfIntroduce(){
        System.out.println("Hello,everyone in the class,my name is"+this.name);
    }
}
