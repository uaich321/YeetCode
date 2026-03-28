package Easy;
/*
  This is a very simple problem. Simply reverse the array in place by swapping
  the first and last element, then the second and second to last element, and so on
  until the middle is reached.

  Make sure to only loop until the middle of the array, otherwise you will end up
  swapping the elements back to their original position, resulting in the original
  array being returned instead of the reversed array.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }
}