package testSwing;

public class User {
    private String name;
    private String secondName;
    private String age;
    private String password;

    public User(String name, String secondName, String age, String password) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
