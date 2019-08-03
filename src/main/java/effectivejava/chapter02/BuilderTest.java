package effectivejava.chapter02;

/**
 * @author weigs
 */
public class BuilderTest {
    public static void main(String[] args) {
        User user = new User.Builder("weigs", "111111").address("广州").age(22).point(1000).build();
        System.out.println(user.getAddress());
        System.out.println(user.getEmail());
        System.out.println(user.getPoint());
    }
}
