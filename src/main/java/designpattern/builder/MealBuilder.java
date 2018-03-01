package designpattern.builder;

/**
 * 建造者模式
 *
 * @author weigs
 * @date 2018/3/1 0001
 */
public abstract class MealBuilder {
    public abstract void buildDrink();

    public abstract void buildFood();

    public abstract Meal getMeal();
}
