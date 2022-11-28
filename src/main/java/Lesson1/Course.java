package Lesson1;

public class Course {
    String result;
    private Obstacles[] obstacles;

    public Course(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }

    public String doIt(Team team){
        result = team.getTeamName() + ": " + '\n';
        for(People people : team.getPeople()){
            result += "участник " +"[" + people.getName() + "]";
            for (Obstacles obstacles1 : getObstacles()){
                int value1 = people.getLimitSwim();
                int value2 = people.getLimitRun();
                int value3 = people.getLimitJump();
                int value4 = obstacles1.getSwim();
                int value5 = obstacles1.getRun();
                int value6 = obstacles1.getJump();
                testSwim(value1,value4);
                testRun(value2,value5);
                testJump(value3, value6);
            }
        }
        return result;
    }

    public void testSwim(int value1, int value4){
        if (value1<=value4) result = result + " справился с плаванием,";
        else result += " столько не проплывает,";
    }
    public void testRun(int value2, int value5){
        if (value2<=value5) result = result + " справился с бегом,";
        else result += " столько не бегает,";
    }
    public void testJump(int value3, int value6){
        if (value3<=value6) result = result + " справился с прыжком," + '\n';
        else result += " столько не прыгает," + '\n';
    }
    public Obstacles[] getObstacles() {
        return obstacles;
    }
    public void setObstacles(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }
}