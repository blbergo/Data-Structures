public class PostfixTestUsingArrayStack {
    public static void main(String[] args) {
        String test = "(d * f + 1) *e/(a^b - b * c + 1) - 72";
        String result = Postfix.convertToPostfix(test);
        System.out.println(String.format("Result: %s", result));
        
    }
}