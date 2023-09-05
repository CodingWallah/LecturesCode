public class LinkedListLecture {
      public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        // sl.add(20);
       // sl.add(30);
        // sl.display();
        // sl.removeFirst();
        // sl.display();
        DoublyLinkedList dl = new DoublyLinkedList();
        CircularLinkedList cl = new CircularLinkedList();
        dl.add(10);
        dl.add(20);
        dl.add(30);
        dl.display();
        dl.removeFirst();
        dl.display();
      }
}

class SinglyLinkedList {
        private class ListNode {
            int val;
            ListNode next;
    
            ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }
    
        private ListNode head;
    
        public SinglyLinkedList() {
            this.head = null;
        }
    
        public void add(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        public void removeFirst() {
            if(head == null) return ;
              head = head.next;
        }
        public void display() {
           // ListNode current = head;
           // while (current != null) {
             //   System.out.print(current.val + " -> ");
             //   current = current.next;
           // }
           for(ListNode current = head;current != null;current = current.next)
                 System.out.print(current.val + " -> "); 
            System.out.println("null");
        }
    }

class DoublyLinkedList {
    private class DoublyListNode {
        int val;
        DoublyListNode next;
        DoublyListNode prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private DoublyListNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void add(int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            DoublyListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void removeFirst(){
        if (head == null) return ;
        head=head.next;
        head.prev = null;
    }
    public void display() {
        DoublyListNode current = head;
        DoublyListNode last=null;
          //FORWARD TRAVEL
        while (current != null) {
            System.out.print(current.val + " <-> ");
            last = current;
            current = current.next;
            
        }
        System.out.println("null");

        //bACKWARd TRAVEL
        while (last != head) {
            System.out.print(last.val + " <-> ");
            last = last.prev;
        }
         System.out.println(last.val+" <-> HEAD");

    }
}

class CircularLinkedList {
    private class CircularListNode {
        int val;
        CircularListNode next;

        CircularListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private CircularListNode head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void add(int val) {
        CircularListNode newNode = new CircularListNode(val);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself for circularity
        } else {
            CircularListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Make it circular
        }
    }

    public void display() {
        CircularListNode current = head;
        do {
            System.out.print(current.val + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("null");
    }
}

