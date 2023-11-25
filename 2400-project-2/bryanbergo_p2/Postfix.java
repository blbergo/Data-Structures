public class Postfix {
    public static String convertToPostfix(String infix) {
        ResizableArrayStack<Character> stack = new ResizableArrayStack<Character>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else {
                switch (c) {
                    case '^':
                        stack.push(c);
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                            postfix += stack.peek();
                            stack.pop();
                        }
                        stack.push(c);
                        break;
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            postfix += stack.pop();
                        }
                        stack.pop();
                        break;
                    default:
                        break;

                }
            }

        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;

    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static double evaluatePostfix(String postfix) {
        LinkedStack<Double> stack = new LinkedStack<Double>();

        for (int i = 0; i < postfix.length(); i++) {
            stack.printStack();
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                String number = "";
                while (Character.isLetterOrDigit(c)) {
                    c = postfix.charAt(i);
                    number += c;
                    i++;
                }

                stack.push(Double.parseDouble(number));
                i--;
            } else {
                switch (c) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        stack.push(stack.pop() - stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '/':
                        // switched around so we use 1/x instead of x/1
                        stack.push((1 / stack.pop() * stack.pop()));
                        break;
                    case '^':
                        stack.push(Math.pow(stack.pop(), stack.pop()));
                        break;
                    default:
                        break;
                }
            }

        }

        return stack.peek();
    }

}
