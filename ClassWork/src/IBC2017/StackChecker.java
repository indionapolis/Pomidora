package sawe;

import sawe.Problem3_22;

public class StackChecker {
    public static void main(String[] args) {
        /* First stack */
        Problem3_22 stack = new Problem3_22();
        System.out.println(stack);
        System.out.println(stack.isEmpty());

        stack.push(3);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        System.out.println(stack.isFull());

        int topElement = stack.top();
        System.out.println("Top: " + topElement);

        topElement = stack.pop();
        System.out.println("Popped: " + topElement);
        System.out.println(stack);

        /* Second stack */
        Problem3_22 smallStack = new Problem3_22();
        smallStack.push(1);
        smallStack.push(2);                  // should not add an element
        System.out.println(smallStack);
        System.out.println(smallStack.isFull());

    }
}
