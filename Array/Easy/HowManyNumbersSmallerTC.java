package Array.Easy;

/*
   To solve this problem, we can use a frequency array, because it will be sorted based on index
   and then simply add the frequency to another sum array that calculates the rolling sum.

   Make sure to update the value before adding it to the sum, because we want the total count of
   numbers less than, NOT less than or equal to. 

   Finally, loop through the original and just update the array in-place with the current count.
 */
public class HowManyNumbersSmallerTC {
    public int[] smallerNumbersThanCurrent(int[] nums) {
         int[] freq = new int[101];
         for (int num: nums) {
            freq[num]++;
         }
         int[] smallerThan = new int[freq.length];
         int rollSum = 0;
         for (int i = 0; i < freq.length; i++) {
            smallerThan[i] = rollSum;
            rollSum += freq[i];
         }
         for (int i = 0; i < nums.length; i++) {
            nums[i] = smallerThan[nums[i]];
         }
         return nums;
    }
} 
