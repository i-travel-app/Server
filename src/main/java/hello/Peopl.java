package hello;


public class Peopl {
    private int age;
    private String sex;

    public Peopl(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public Peopl() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
