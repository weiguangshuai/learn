package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 2, 6, 4, 8, 9};
        test(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {
        if (array.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int tmp = array[left];
        while (left < right) {
            //判断是否比基准数大，如果大则不移动
            while (left < right && array[right] >= tmp) {
                right--;
            }
            //找到比基准数小的，移动到左边的位置
            array[left] = array[right];
            //判断是否比基准数小，如果小则不移动，继续判断
            while (left < right && array[left] <= tmp) {
                left++;
            }
            //如果大则移动到右边的位置
            array[right] = array[left];
        }
        //将基准值补到坑中
        array[left] = tmp;
        //将基准值左右两边的数继续按照上面的规则排序
        sort(array, low, left - 1);
        sort(array, left + 1, high);
    }

    public static void test(int[] array, int low, int high) {
        if (array.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int temp, left, right;
        temp = array[low];
        left = low;
        right = high;
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;

        test(array, low, left - 1);
        test(array, left + 1, high);
    }
}
