package Easy;

/*

In order to solve this problem, we loop through the haystack string until we have
less characters left in the haystack than the length of the needle, because 
if there are less characters left, then there is no way for the needle to be 
in the haystack.

Then, we take the substring of the haystack that is the same length as the needle, 
and we check if it is equal to the needle. If it is, then we return the index of the start of that substring, which is i.

If it is not, then we increment i by 1 and continue the loop.

At the end, if we have gone through the entire haystack and 
haven't found the needle, then we return -1, which indicates that the needle is not in the haystack.

Note that I used less than or equal to because in java, the second parameter of
 the substring function is exclusive, so if we want to take a substring of length 
 n, we have to go up to i + n, which is the length of the needle.

 Overall, a really easy problem.
 
*/ 
public class IndexFirstOccurenceStr {
    public int strStr(String haystack, String needle) {
        int i = 0;
        while(i + needle.length() <= haystack.length()) {
            String substr = haystack.substring(i, i + needle.length());
            if (substr.equals(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}