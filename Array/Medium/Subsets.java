package Array.Medium;

import java.util.ArrayList;
import java.util.List;

/*
Subtopic: Backtracking

To solve this problem, we can use backtracking. 
We can use a helper function that takes in the index of the current number, the current list of numbers, and the result list.

The key point here is to notice that we can recursively include or exclude the current
number to get all the possible subsets. 

We have two recursive calls, one that includes the current number and one that excludes it. 

At the end, we add the current list to the result list.

Note that between the two recursive calls, we have to remove the 
last number from the current list, 
because we are backtracking and we want to explore the other possibility of excluding the current number.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }
    private void dfs(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        dfs(index + 1, nums, current, result);
        current.remove(current.size() - 1);
        dfs(index + 1, nums, current, result);
    } 
}
