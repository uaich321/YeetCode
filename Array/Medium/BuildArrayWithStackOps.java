package Array.Medium;

import java.util.ArrayList;
import java.util.List;

/*
To solve this problem, just loop through the array and keep a counter for the stream. 
Everytime it's not the actual value, just push and pop it, otherwise push, and I used a shortcut
i++ in the condition to increment i both in and outside the loop at once.

We were technically implementing a stack, so I named the list stack. 
 */
public class BuildArrayWithStackOps {
    public List<String> buildArray(int[] target, int n) {
        List<String> stack = new ArrayList<String>();
        int i = 1;
        for (int tar: target) {
            while (i++ < tar) {
                stack.add("Push");
                stack.add("Pop");
            }
            
            stack.add("Push");
        }
        return stack;
    }
}
