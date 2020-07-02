package JDBC;

public class Student {
    private int s_id;
    private String s_name;
    private String s_sex;
    private int s_class;

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public int getS_class() {
        return s_class;
    }

    public void setS_class(int s_class) {
        this.s_class = s_class;
    }

    public Student(int s_id, String s_name, String s_sex, int s_class) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.s_class = s_class;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_class=" + s_class +
                '}';
    }
}
