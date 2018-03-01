package designpattern.builder;

/**
 * @author weigs
 * @date 2018/3/1 0001
 */
public class AMealBuilder extends MealBuilder {

    private Meal meal = new Meal();

    @Override
    public void buildDrink() {
        meal.setDrink("A Drink");
    }

    @Override
    public void buildFood() {
        meal.setFood("A Food");
    }

    @Override
    public Meal getMeal() {
        buildDrink();
        buildFood();
        return meal;
    }
}
