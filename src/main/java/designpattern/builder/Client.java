package designpattern.builder;

/**
 * @author weigs
 * @date 2018/3/1 0001
 */
public class Client {
    public static void main(String[] args) {
        KFCWatier kfcWatier = new KFCWatier();
        kfcWatier.setMealBuilder(new AMealBuilder());
        System.out.println(kfcWatier.getMeal().getDrink());
    }
}
