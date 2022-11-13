package Lesson1;

public class Team {
    private String teamName;
    private People[] people;

    public Team(String teamName, People[] people) {
        this.teamName = teamName;
        this.people = people;
    }

    public void teamInfo(){
        for (People peoples : getPeople()){
            System.out.println("["+peoples.getName() +"]"+" Возраст: "+peoples.getAge()+" лет,"
                    +" проплывает "+peoples.getLimitSwim()+"м," +" пробегает "+peoples.getLimitRun()+"м,"
                    +" прыгает на "+peoples.getLimitJump()+" м");
        }

    }

    public String getTeamName() {return teamName;}

    public void setTeamName(String teamName) {this.teamName = teamName;}

    public People[] getPeople() {return people;}

    public void setPeople(People[] people) {this.people = people;}

}