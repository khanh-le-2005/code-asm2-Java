public class student {
    private String code;
    private String name;
    private int age;
    private String email;
    private String phone;
    private int gender;
    private float grade;

    public student (String code, String name, int age, String email, String phone, int gender, float grade) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getGender() {
        return gender;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + (gender == 0 ? "Male" : "Female") +
                ", grade=" + grade +
                '}';
    }
}
