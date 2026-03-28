package Medium;

/*
    To solve this problem, we need to use the sliding window technique.

    Here, we set start, end, and length to zero. We also create a hashmap to store
    all the characters we read so far. 

    In the loop, we read the character at the end pointer and see if its already
    in the map. If it is, that means a repeat. In the repeat, we shift the left pointer
    one to the right. 

    Note that we have to take the max of the current start and the index of the repeated character + 1,
    because the repeated character may have been seen before, 
    and we don't want to shift the left.

    After that, we check if the length of the current substring is greater 
    than the longest length we've seen so far. If it is, we update the longest length. 
    
    Finally, we add the character at the end pointer to the map and 
    move the end pointer to the right by one.

    Return the length variable at the end, which is the longest length of a substring without repeating characters.
*/
import java.util.HashMap;

public class LongestNonRSubstring {
     public int lengthOfLongestSubstring(String s) {
        int end = 0;
        int start = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int strlen = s.length();
        while (end < strlen) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                start = Math.max(map.get(endChar) + 1, start);
            }
            if (end - start + 1 > len) {
                len = end - start + 1;
            }
            map.put(endChar, end);
            end++;
        }
        return len;
    }
}
