package Array.Easy;
/*

Subtopic: Map

The bad version of two sum problem is to use two loops to find the solution, which
has a time complexity of O(n^2). Despite the power of high-speed computing,
this approach could be better. 

Two-sum is reliant on three main things, the target value, the first number,
and the second number. 

We know this equation: target = firstNum + secondNum

Now, if we rearrange the equation, secondNum = target - firstNum. 

We are given the target and the array, so what we can do is loop through the array
and treat the current number as the fisrstNum, and then see if the secondNum exists
in the array.

The problem is, how do we keep track of the numbers we have seen so far? How do
we do this without using two loops?

What data structure can allow us to track and access numbers in constant time?

The answer to this is simply using a hash map. We can use the hash map to store the
key as the number, and the value as the index of the number.

If the map doesn't contain the secondNumber(refer to the rearranged equation) - which is
guaranteed in the first pass of the loop - then we add the firstNum to the map and move on.

Eventually, the map will contain the secondNum, and there we have found the two solutions,
the firstNum, which is the current index, and the secondNum, which is in the map.

All we have to do now is return an array containing the two indices
(i.e the values of the firstNum and secondNum keys in the map).

This improved approach has a time complexity of O(n) and a space complexity of O(n) due to the hash map.
*/ 
import java.util.HashMap;
public class TwoSum {
    public int[] twoSumGood(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int[] twoSumBad(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
