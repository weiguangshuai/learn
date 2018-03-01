package designpattern.builder;

/**
 * 建造者模式中的director
 *
 * @author weigs
 * @date 2018/3/1 0001
 */
public class KFCWatier {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal getMeal() {
        return mealBuilder.getMeal();
    }
}
