package exception;

import org.junit.Test;

/**
 * @author weigs
 * @date 2017/12/21 0021
 */
public class ReturnAboutTryCatchFinally {
    @Test
    public void testTryFinally() {
        System.out.println(tryFinally());
    }

    public int tryFinally() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    @Test
    public void testTryCatchFinally() {
        System.out.println(tryCatchFinally());
    }

    public int tryCatchFinally() {
        try {
            int i = 10 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
