package concurrent.atomic;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    //不加同步关键字，多线程会出现生成的数据重复的情况
    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
