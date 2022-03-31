package algorithm;

/**
 * 二分法
 */
public class Dichotomy {

    public static void main(String[] args) {
        int[] tmp = {1, 2, 4, 5, 7, 8, 9};
        System.out.println(dichotomyIndex(tmp, 1));
    }

    public static int dichotomyIndex(int[] array, int result) {
        int start = 0;
        int end = array.length - 1;
        while (end >= start) {
            int mid = (end + start) / 2;
            if (array[mid] == result) {
                return mid;
            }
            if (array[mid] > result) {
                end = mid - 1;
            }
            if (array[mid] < result) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
