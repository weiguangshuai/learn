package designpattern.builder;

/**
 * @author weigs
 * @date 2018/3/1 0001
 */
public class BMealBuilder extends MealBuilder {
    private Meal meal = new Meal();

    @Override
    public void buildDrink() {
        meal.setDrink("B Drink");
    }

    @Override
    public void buildFood() {
        meal.setFood("B Food");
    }

    @Override
    public Meal getMeal() {
        buildDrink();
        buildFood();
        return meal;
    }
}
