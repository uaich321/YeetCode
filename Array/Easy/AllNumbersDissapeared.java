package Array.Easy;

/*
To solve this problem, we make the index that is supposed to match the number into a negative number, and
keep it negative. This tells us that missing numbers would have a positive index. 

Now, we do a second pass and add all positive indices to our list and return that. 
 */
import java.util.ArrayList;
import java.util.List;

public class AllNumbersDissapeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            int index = Math.abs(num) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
