package algorithm;

/**
 * 二分法
 */
public class Dichotomy {

    public static void main(String[] args) {
        int[] tmp = {1, 2, 2, 5, 7, 8, 9};//7
//        System.out.println(dichotomyIndex(tmp, 9));
//        System.out.println(dichotomyIndexLeft(tmp, 10));
        System.out.println(dichotomyIndexRight(tmp, 9));
    }

    /**
     * 正常二分查找
     *
     * @param array  数组
     * @param result 查找结果
     * @return index
     */
    public static int dichotomyIndex(int[] array, int result) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == result) {
                return mid;
            }
            if (array[mid] > result) {
                right = mid - 1;
            }
            if (array[mid] < result) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 找到满足条件最左下标
     *
     * @param array  数组
     * @param result 查找结果
     * @return 最左下标
     */
    public static int dichotomyIndexLeft(int[] array, int result) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == result) {
                right = mid;
            }
            if (array[mid] > result) {
                right = mid - 1;
            }
            if (array[mid] < result) {
                left = mid + 1;
            }
        }
        return array[left] == result ? left : -1;
    }


    /**
     * 找到满足条件最右下标
     *
     * @param array  数组
     * @param result 查找结果
     * @return 最右下标
     */
    public static int dichotomyIndexRight(int[] array, int result) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == result) {
                left = mid + 1;
            }
            if (array[mid] > result) {
                right = mid - 1;
            }
            if (array[mid] < result) {
                left = mid + 1;
            }
        }
        if (left - 1 < 0 || left - 1 >= array.length) {
            return -1;
        }
        System.out.println(array[left - 1]);
        return array[left - 1] == result ? left - 1 : -1;
    }

}
