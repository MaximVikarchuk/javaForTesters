package hw1;

public enum Obscacle {
    RUNNING("Бег", 53), JUMPING("Прыжки", 51), SWIMING("Плаванье", 58);
    private String obstacle;
    private int age;
    Obscacle(String obstacle, int age){
        this.obstacle = obstacle;
        this.age = age;
    }
    public boolean ablePass(int age){
        return (age > 14 && age <= this.age );
    }
}
