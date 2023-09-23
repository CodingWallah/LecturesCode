import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueLecture {
    public static void main(String[] args) {
        // Create a queue using LinkedList
        //Queue is Interface
       //  Queue<String> queue = new LinkedList<>();
        Queue<String> queue = new ArrayDeque<>();
       // Queue<String> queue = new PriorityQueue<>();

        // Enqueue (add) elements to the queue
        queue.offer("Shivam");
        queue.offer("Sharma");
        queue.offer("Coding");
        queue.offer("Wallah");
        

        // Display the elements in the queue
        System.out.println("Queue: " + queue);

        // Dequeue (remove) elements from the queue
        String removedElement = queue.poll();
        System.out.println("Removed Element: " + removedElement);

        // Peek (retrieve) the front element without removing it
        String frontElement = queue.peek();
        System.out.println("Front Element: " + frontElement);

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is Queue Empty? " + isEmpty);

        // Get the size of the queue
        int size = queue.size();
        System.out.println("Queue Size: " + size);
        //--------------------------------------------------------
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        // Insert elements with priorities
        priorityQueue.offer(50);
        priorityQueue.offer(20);
        priorityQueue.offer(80);
        priorityQueue.offer(10);
        
        System.out.println("Print PriorityQ: " + priorityQueue);
        // Peek at the highest-priority element
        int highestPriority = priorityQueue.peek();
        System.out.println("Highest Priority: " + highestPriority);
        
        // Remove and retrieve the highest-priority element
        int rE = priorityQueue.poll();
        System.out.println("Removed Element: " + rE);
    }

    public static class QueueReverse{
      public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
       
        while (!queue.isEmpty()) stack.push(queue.poll()); 
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
      } 
    }  

    public static class MyDoubleEndedQ{
        public static void main(String[] args) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            //last me add krenge
            queue.offer(1);
            queue.offerLast(2);
            queue.add(3);
            queue.addLast(4);

            //first me add krenge
            queue.addFirst(0);
            queue.offerFirst(-1);

            //remove from first
            queue.remove();
            queue.poll();
            queue.removeFirst();
            queue.pollFirst();

            System.out.println(queue.peek());
            System.out.println(queue.peekFirst());
            
            System.out.println(queue);
        }
    }
    
    public static class QueueUsingArray {
        private int[] array;
        private int front;
        private int rear;
        private int size;
        private int capacity;
    
        public QueueUsingArray(int capacity) {
            this.capacity = capacity;
            this.array = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }
    
        public void enqueue(int item) {
            if (isFull()) {
                System.out.print("Queue is full");
            }
            rear = (rear + 1) % capacity;
            array[rear] = item;
            size++;
        }
    
        public int dequeue() {
            if (isEmpty()) {
                System.out.print("Queue is Empty");
            }
            int item = array[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    
        public int peek() {
            if (isEmpty()) {
                System.out.print("Queue is Empty");
            }
            return array[front];
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public boolean isFull() {
            return size == capacity;
        }
    
        public int size() {
            return size;
        }
    
        public static void main(String[] args) {
            QueueUsingArray queue = new QueueUsingArray(5);
    
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
    
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Peek: " + queue.peek());
    
            queue.enqueue(4);
            queue.enqueue(5);
    
            System.out.println("Size: " + queue.size());
    
            while (!queue.isEmpty()) {
                System.out.println("Dequeue: " + queue.dequeue());
            }
        }
    }
    

    public static class QueueUsingLinkedList {
        private class Node {
            int data;
            Node next;
    
            Node(int data) {
                this.data = data;
            }
        }
    
        private Node front;
        private Node rear;
        private int size;
    
        public QueueUsingLinkedList() {
            front = null;
            rear = null;
            size = 0;
        }
    
        public void enqueue(int item) {
            Node newNode = new Node(item);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode; // rear.next;
            }
            size++;
        }
    
        public int dequeue() {
            if (isEmpty()) {
                 System.out.println("Queue is empty");
            }
            int data = front.data;
            front = front.next;
            size--;
            return data;
        }
    
        public int peek() {
            if (isEmpty()) {
                 System.out.println("Queue is empty");
            }
            return front.data;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public int size() {
            return size;
        }
    
        public static void main(String[] args) {
            QueueUsingLinkedList queue = new QueueUsingLinkedList();
    
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
    
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Peek: " + queue.peek());
    
            queue.enqueue(4);
            queue.enqueue(5);
    
            System.out.println("Size: " + queue.size());
    
            while (!queue.isEmpty()) {
                System.out.println("Dequeue: " + queue.dequeue());
            }
        }
    }
    
    
    
}
