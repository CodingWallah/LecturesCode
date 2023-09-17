import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueLecture {
    public static void main(String[] args) {
        // Create a queue using LinkedList
        //Queue is Interface
         Queue<String> queue = new LinkedList<>();
        //Queue<String> queue = new ArrayDeque<>();
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
        
        System.out.println("Print PriorityQ: " + priorityQueue);
        // Peek at the highest-priority element
        int highestPriority = priorityQueue.peek();
        System.out.println("Highest Priority: " + highestPriority);
        
        // Remove and retrieve the highest-priority element
        int rE = priorityQueue.poll();
        System.out.println("Removed Element: " + rE);
    }

}
