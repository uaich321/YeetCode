package Array.Easy;

class MaxGenArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0]= 0;
        nums[1] = 1;
        int i = 0;
        while (i < n + 1 && 2 * i + 1 < n + 1) {
            nums[2 * i] = nums[i];
            nums[2 * i + 1] = nums[i] + nums[i + 1];
            i++;
        }
        int max = -1;
        for (int m: nums) {
            max = Math.max(m, max);
        }
        return max;
    }
}
