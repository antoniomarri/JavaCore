package Lesson1;

public class Main {
    public static void main(String[] args) {

        People[] people = new People[4];
        people[0] = new People("Спортсмен 1", 25, 50, 250, 5);
        people[1] = new People("Спортсмен 2", 30, 40,200, 3);
        people[2] = new People("Спортсмен 3", 20, 100,300, 4);
        people[3] = new People("Спортсмен 4", 40, 20,100, 2);
        Team team = new Team("Команда", people);

        Obstacles[] obstacles = new Obstacles[1];
        obstacles[0] = new Obstacles(50, 250, 5);
        Course course = new Course(obstacles);

        String result = course.doIt(team);
        System.out.println(result);

        team.teamInfo();
    }
}