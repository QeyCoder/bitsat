import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gaurav on 01/10/17.
 */
public class BraceChecker {

    /**
     * using stack here to store the input in case there is opening braces insert to stack else pop from the stack and match with incoming input
     *
     * @param braces
     * @return braces==balanced? true: false;
     */
    public boolean isValid(String braces) {

        List<String> openBraces = Arrays.asList(new String[]{"{", "(", "["});
        String[] splittedInput = braces.split("");
        Stack<String> stringStack = new Stack();
        for (int i = 0; i < splittedInput.length; i++) {
            if (openBraces.contains(splittedInput[i])) {
                stringStack.push(splittedInput[i]);
            } else {
                if (!stringStack.empty()) {
                    String topElement = stringStack.pop();
                    if (!compare(splittedInput[i], topElement)) {
                        return false;
                    }
                } else {
                    //if stack become empty and still incoming is there then return false
                    return false;
                }

            }

        }
        //if stack have some element braces are unbalanced
        if (stringStack.size() > 0) {
            return false;
        }
        return true;

    }

    /**
     * @param inputParam : input coming by user
     * @param topElement : top element of stack to check
     *                   input and topelement should match with each other
     * @return
     */

    private boolean compare(String inputParam, String topElement) {
        if (inputParam.equals(")") && topElement.endsWith("(")) {
            return true;
        }
        if (inputParam.equals("}") && topElement.endsWith("{")) {
            return true;
        }
        if (inputParam.equals("]") && topElement.endsWith("[")) {
            return true;
        }
        return false;
    }


}
