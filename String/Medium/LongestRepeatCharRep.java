package Medium;

/*
 This was a ver interesting problem.
 To solve this problem, we can use the sliding window technique, and what we also
 know is that the we can use a frequency array to find the max feequency of the
 window. For the window, we can find the length that is not max frequency,
 and if that window is less than or equal to k, then good, we can update the max
 length.

 Otherwise, if it's greater, we substract the frequency from the array and we move
 the left window forward by 1 and recalculate the window size.

 We make sure to update the maxlength at the end as well.

 Also, maxFreq is Math.max of the current maxFreq and the 
 frequency of the end character, because we want to make sure
 that we have the max frequency of the current window, and if we don't update it, 
 then we may have a window that is larger than k, 
 but we won't know because we won't have the max frequency of the current window.
*/

public class LongestRepeatCharRep {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0;
        int maxFreq = 0;
        int maxlen = 0;
        int strlen = s.length();
        for (int end = 0; end < strlen; end++) {
            char endChar = s.charAt(end);
            freq[endChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[endChar - 'A']);
            int win = end - start + 1;
            if (win - maxFreq > k) {
                char startChar = s.charAt(start);
                freq[startChar - 'A']--;
                start++;
                win = end - start + 1;
            }
            maxlen = Math.max(win, maxlen);
        }
        return maxlen;
    }
}