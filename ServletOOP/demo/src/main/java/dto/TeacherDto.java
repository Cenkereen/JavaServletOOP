package dto;
public class TeacherDto{
    private int id;
    private String name;
    private String className;
    private int age;

    public TeacherDto(int id, String name, String className, int age) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
