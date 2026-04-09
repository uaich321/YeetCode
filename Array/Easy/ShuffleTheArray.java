package Array.Easy;
/*
    In order to solve the problem, we simply see that the x's are in even indices and y's
    are in the odd indices. Recall the formal definition of an even and odd number and use
    that to assign the indices of the new array to the original array.

    To get the y elements, add n to the current index as they are at index n or above. 
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];       
            res[2 * i + 1] = nums[i + n];
        }
        return res;
    }
}
