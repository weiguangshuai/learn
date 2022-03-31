package leetcode.day01;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class FindMedianSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, temp, 0, nums1.length);
        System.arraycopy(nums2, 0, temp, nums1.length, nums2.length);

        for (int i = 1; i < temp.length; i++) {
            for (int j = i; j > 0; j--) {
                if (temp[j - 1] > temp[j]) {
                    int t = temp[j];
                    temp[j] = temp[j - 1];
                    temp[j - 1] = t;
                }
            }
        }
        return 0.00;
    }
}
