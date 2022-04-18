package streamPractice;

public class Dish {
    private String name;
    private int calories;

    public Dish(Integer i) {
        this.calories =i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
