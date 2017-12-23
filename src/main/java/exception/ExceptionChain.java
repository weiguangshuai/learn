package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 异常链
 *
 * @author weigs
 * @date 2017/12/21 0021
 */
public class ExceptionChain {
    public static void main(String[] args) {
        try {
            B();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void A() throws MyException {
        try {
            FileReader fileReader = new FileReader("ddd.txt");
        } catch (FileNotFoundException e) {
            throw new MyException("文件没有找到--01", e);
        }
    }

    public static void B() throws MyException {
        try {
            A();
        } catch (MyException e) {
            throw new MyException("文件没有找到--02", e);
        }
    }
}

class MyException extends Exception {

    public MyException() {
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
