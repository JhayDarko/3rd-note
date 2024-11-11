public class ValidateParenthesis {

    public static boolean isValidParenthesis(String string) {
        int count = 0;
        for (char character : string.toCharArray()) {
            if (character == '(') {
                count++;
            } else if (character == ')') {
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidParenthesis("()"));
        System.out.println(isValidParenthesis(")(()))"));
        System.out.println(isValidParenthesis("("));
        System.out.println(isValidParenthesis("(())((()())())"));
    }
}
