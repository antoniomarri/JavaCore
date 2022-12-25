package Lesson1;

public class People {
    private String name;
    private int age;
    private int limitSwim;
    private int limitRun;
    private int limitJump;

    public People(String name, int age, int limitSwim, int limitRun, int limitJump) {
        this.name = name;
        this.age = age;
        this.limitSwim = limitSwim;
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public int getLimitSwim() {return limitSwim;}

    public void setLimitSwim(int limitSwim) {this.limitSwim = limitSwim;}

    public int getLimitRun() {return limitRun;}

    public void setLimitRun(int limitRun) {this.limitRun = limitRun;}

    public int getLimitJump() {return limitJump;}

    public void setLimitJump(int limitJump) {this.limitJump = limitJump;}

}