package String;
import java.util.Stack;
/*
    To solve this problem, note that the way the parentheses match is if the last opening bracket
    is the first one closed.

    If you see the keywords last and first, then that says that this is a LIFO
    principal, which points us to using a stack data structure. From there, the logic is
    pretty straightforward. We add any opening bracket to the stack, 
    and if we see a closing bracket, then we check if the closing bracket matches
    the last opening bracket, which we pop from the stack. 
    
    One important thing to watch out for is making sure that the stack is not empty
    If we encounter the closing bracket and the stack is empty, then that tells us that
    there are no opening brackets to match, meaning we instantly return false.

    At the end of the loop, you may be prompted to return true, but that is not correct.
    Think of the case where there are just opening brackets only in the string. In that case,
    the answer would be false, because that isn't a valid string.

    Thus, at the end, we check if the stack is empty and return true if it is and false if it
    isn't.
*/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char latest = stack.pop();
                if ((c == ')' && latest != '(') || (c == '}' && latest != '{') || (c == ']' && latest != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
