/*
  First, we check if the lengths of the two strings are different. 
  If they are, we can immediately return false since they cannot be anagrams.

  There are two cases to watch out for after this:
    1. There is a letter in t not in s. Then, we return false.
    2. There is a repeated letter in t that is not repeated in s. 
    Then, we return false.

    The best way to solve this in O(n) is to use a frequency array that records
    the frequency of each letter. If the strings are truly anagrams, then each
    letter should have the same frequency in both strings.

    But, how can we write this in code?

    A good idea would be to add 1 to the array each time we see a letter in s,
    and subtract 1 from the array each time we see a letter in t. 
    If the strings are anagrams, then the frequency array should be all 0s at the end, 
    since we add and substract 1 the same number of times.

    Finally, we loop through the frequency array and check if there are any non-zero values.
    If there are, then we return false, otherwise we return true.

    Personally, I used a for-each loop since I wouldn't have to waste time
    writing and accessing the character at the index, which is a bit more
    efficient.

    If you want to make the code look cleaner, you can use one normal for loop
    to add and substract to the frequency array in the same loop, 
    but I think that would be less efficient since you would have to access the 
    character at the index twice, which is more time consuming than using two 
    for-each loops.
 
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) {
            return false;
         }
         int[] freq = new int[26];
         for (char c: s.toCharArray()) {
            int val = c - 'a';
            freq[val]++;
         }
         for (char c: t.toCharArray()) {
            int val = c - 'a';
            freq[val]--;
         }
         for (int f: freq) {
            if (f != 0) {
                return false;
            }
         }
         return true;
    }
}