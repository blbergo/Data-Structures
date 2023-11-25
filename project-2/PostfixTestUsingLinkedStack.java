public class PostfixTestUsingLinkedStack {
    public static void main(String[] args) {
        String postfix = "5 7 * 1 + 6 *2 3 ^ 3 4 * - 1 + / 72 -";
        System.out.println("Postfix: " + postfix);
        System.out.println("Result: " + Postfix.evaluatePostfix(postfix));
    }
}
