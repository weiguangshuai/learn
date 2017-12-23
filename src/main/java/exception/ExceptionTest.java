package exception;

import org.junit.Test;

/**
 * @author weigs
 * @date 2017/12/21 0021
 */
public class ExceptionTest {

    @Test
    public void test2() {
        try {
            C();
        } catch (BException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void C() throws BException {
        try {
            A();
        } catch (AException e) {
            throw new BException();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        try {
            Exception exception = null;
            try {
                A();
            } catch (Exception e) {
                exception = e;
            } finally {
                try {
                    B();
                } catch (BException e) {
                    if (exception != null) {
                        exception.addSuppressed(e);
                    } else {
                        exception = e;
                    }
                }
                if (exception != null) {
                    throw exception;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println(throwable);
            }
        }
    }

    static void A() throws AException {
        throw new AException();
    }

    static void B() throws BException {
        throw new BException();
    }
}

class AException extends Exception {
    @Override
    public String toString() {
        return "AException{}";
    }
}

class BException extends Exception {
    public BException(Throwable cause) {
        super(cause);
    }

    public BException() {

    }

    @Override
    public String toString() {
        return "BException{}";
    }
}