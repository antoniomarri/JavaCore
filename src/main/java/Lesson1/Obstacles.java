package Lesson1;

public class Obstacles {
    private int swim;
    private int run;
    private int jump;

    public Obstacles(int swim, int run, int jump) {
        this.swim = swim;
        this.run = run;
        this.jump = jump;
    }


    public int getSwim() {return swim;}

    public void setSwim(int swim) {this.swim = swim;}

    public int getRun() {return run;}

    public void setRun(int run) {this.run = run;}

    public int getJump() {return jump;}

    public void setJump(int jump) {this.jump = jump;}

}
