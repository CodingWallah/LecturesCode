import java.util.Stack;
import java.util.ArrayList;

public class StackLecture {
    public static class PlateStackExample {
        public static void main(String[] args) {
            // Create a stack to represent our plate stack
            Stack<String> plateStack = new Stack<>();
    
            // Adding plates to the stack
            plateStack.push("P1");
            plateStack.push("P2");
            plateStack.push("P3");
    
            System.out.println("Current stack of plates: " + plateStack);
    
            // Removing a plate (Last-In-First-Out)
            String removedPlate = plateStack.pop();
            System.out.println("Removed plate: " + removedPlate);//p3
            System.out.println("Updated stack of plates: " + plateStack);
    
            // Peeking at the top plate without removing it
            String topPlate = plateStack.peek();
            System.out.println("Top plate (without removing): " + topPlate);//p2
            System.out.println("Current stack of plates: " + plateStack);
    
            // Checking if the stack is empty
            boolean isEmpty = plateStack.isEmpty();
            System.out.println("Is the stack empty? " + isEmpty);//false
        }
    }
    
    public static class StackUsingArray {
        private int maxSize;    // Maximum size of the stack
        private int top;        // Index of the top element
        private int[] stackArray;
    
        // Constructor to initialize the stack
        public StackUsingArray(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;  // Initialize top to -1 (empty stack)
        }
    
        // Method to push an element onto the stack
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack is full. Cannot push " + value);
            } else {
                stackArray[++top] = value;
            }
        }
    
        // Method to pop the top element from the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot pop.");
                return -1;  // Return a sentinel value indicating an error
            } else {
                return stackArray[top--];
            }
        }
    
        // Method to check if the stack is empty
        public boolean isEmpty() {
            return (top == -1);
        }
    
        // Method to check if the stack is full
        public boolean isFull() {
            return (top == maxSize - 1);
        }
    
        // Method to peek at the top element without popping it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Cannot peek.");
                return -1;  // Return a sentinel value indicating an error
            } else {
                return stackArray[top];
            }
        }
    
        // Method to get the current size of the stack
        public int size() {
            return top + 1;
        }
    
        public static void main(String[] args) {
            StackUsingArray stack = new StackUsingArray(5);
    
            stack.push(10);
            stack.push(20);
            stack.push(30);
    
            System.out.println("Top element: " + stack.peek());//30
            System.out.println("Stack size: " + stack.size());//3
    
            System.out.println("Popped element: " + stack.pop());//30
            System.out.println("Popped element: " + stack.pop());//20
    
            System.out.println("Is the stack empty? " + stack.isEmpty());
        }
    }
   
    public static class StackUsingArrayList<T> {
    private ArrayList<T> stack;

    // Constructor to initialize the stack
    public StackUsingArrayList() {
        stack = new ArrayList<>();
    }

    // Method to push an element onto the stack
    public void push(T value) {
        stack.add(value);
    }

    // Method to pop the top element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        return stack.remove(stack.size() - 1);
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Method to peek at the top element without popping it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return stack.get(stack.size() - 1);
    }

    // Method to get the current size of the stack
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackUsingArrayList<Integer> stack = new StackUsingArrayList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}

    public static class StackUsingLinkedList {
        private Node top;   // Top of the stack
        private int size;   // Number of elements in the stack

        // Constructor to initialize the stack
        public StackUsingLinkedList() {
            top = null;      // Initialize top to null (empty stack)
            size = 0;
        }

        // Node class to represent elements in the stack
        private class Node {
            Object data;
            Node next;

            Node(Object data) {
                this.data = data;
                this.next = null;
            }
        }

        // Method to push an element onto the stack
        public void push(Object value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            size++;
        }

        // Method to pop the top element from the stack
        public Object pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot pop.");
            }
            Object poppedValue = top.data;
            top = top.next;
            size--;
            return poppedValue;
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Method to peek at the top element without popping it
        public Object peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot peek.");
            }
            return top.data;
        }

        // Method to get the current size of the stack
        public int size() {
            return size;
        }

        public static void main(String[] args) {
            StackUsingLinkedList stack = new StackUsingLinkedList();

            stack.push(10);
            stack.push(20);
            //stack.push("Hello");
            //stack.push(3.14);

            System.out.println("Top element: " + stack.peek());
            System.out.println("Stack size: " + stack.size());

            System.out.println("Popped element: " + stack.pop());
            System.out.println("Popped element: " + stack.pop());

            System.out.println("Is the stack empty? " + stack.isEmpty());
        }
    }

}
