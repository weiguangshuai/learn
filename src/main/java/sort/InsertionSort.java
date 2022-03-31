package sort;

import java.util.Arrays;

/**
 * 直接插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 3, 5, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        if (array.length < 2) {
            throw new RuntimeException("不需要排序，少于两个元素");
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 改进版，减少循环次数
     *
     * @param array
     */
    public static void sortPro(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] <= array[j]) {
                    break;
                }
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }
}
