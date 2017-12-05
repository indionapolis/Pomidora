package sawe;

public class Problem3_22 {
    private int[] data = null;
    private int top = -1;
    private int size;

    /**
     * Create a new stack of `n` elements
     *
     * 11 maximum number of elements in the stack
     */
    Problem3_22() {
        data = new int[11];
        this.size = 11;
    }


    /**
     * Pop a number from the stack and remove it
     *
     * @return number from the top of the stack
     */
    public int pop() {
        return data[top--];
    }

    /**
     * Get a number from the stack without removing it
     *
     * @return number from the top of the stack
     */
    public int top() {
        return data[top];
    }

    /**
     * Push given number to the top of the stack
     *
     * @param number an integer
     */
    public void push(int number) {
        data[++top] = number;
    }

    /**
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * @return true if stack is full, false otherwise
     */
    public boolean isFull() {
        if (top == size - 1){
            return true;}
        else{
            return false;}
    }

    /**
     * @return string representation of the stack
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = top; i > -1; i--) {
            result.append(data[i] + " ");
        }
        result.append("\n^");
        return result.toString();
    }
}