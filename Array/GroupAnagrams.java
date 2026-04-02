package Array;
/*
Subtopic: Map

Contrary to the name of the problem, this problem doesn't inherit from valid anagram.
Using a frequency array to count the frequency of each character in the string won't work, 
because it isn't concise and effecient for a problem of this scale.

Instead, a better approach would be to see something common between anagrams, which is that
if you sort the characters, then the same string is produced. The best way to do so would be
converting the string to a character array and use Arrays.sort, then convert back to a string.

Additionally, a HashMap should also be used to the sorted keys, because we won't have
to keep track of the indexes of the strings, and we can just add the string to
the value of the key, which is a list of the strings that match the sorted key.

So, as we use an enhanced for loop to loop through the strings, we convert the
strings to character arrays, sort them, and then use the computeIfAbsent method
to add the string to the value of the key; should the key not exist, then a new
list will be created and the string will be added. Also, for computeIfAbsent, the
function will only be called if the key doesn't exist, so that is computationally 
efficient.

Finally, we make a new list of lists to return, and we loop through the 
keys of the map and add the values of the keys to the return list, 
and then we return the return list.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            map.computeIfAbsent(new String(temp), val -> new ArrayList<>()).add(str);
        } 
        List<List<String>> ret = new ArrayList<>();
        String[] keys = map.keySet().toArray(new String[0]);
        for (String key: keys) {
            ret.add(map.get(key));
        }
        return ret;
    }
}
