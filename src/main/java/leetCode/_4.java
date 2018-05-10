package leetCode;

public class _4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //input 2 is always greater in length
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        //high will be always smaller array
        int high = y;


        while (low <= high) {

            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;


            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX - 1];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums1[partitionY];

            if (maxLeftX <= minRightY && minRightX >= maxLeftY) {
                if (x + y % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }

            } else if (minRightX < maxLeftY) {
                low = partitionX + 1;
            } else {
                high = partitionX - 1;
            }

        }

        return -1;
    }
}
