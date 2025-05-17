package entity;
public class Student {
    private int id;
    private String name;
    private float gpa;
    private int age;

    public Student(int id, String name, float gpa, int age) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
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

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
