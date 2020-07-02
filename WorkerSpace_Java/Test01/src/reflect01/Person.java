package reflect01;

public class Person {
    private String name;
    private int age;
    public int a;
    protected char b;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                ", b=" + b +
                '}';
    }

    public void eat(){
        System.out.println("吃饭");
    }

    /**
     *
     * @param name
     */
    private void eat(String name){
        System.out.println(name + "吃饭");
    }
}
