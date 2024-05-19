package lab03;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 */

public class Lab3Main 
{

    public static void main(String[] args) 
    {
    	Dollar[] currencyArray = new Dollar[20];
        currencyArray[0] = new Dollar(57.12);
        currencyArray[1] = new Dollar(23.44);
        currencyArray[2] = new Dollar(87.43);
        currencyArray[3] = new Dollar(68.99);
        currencyArray[4] = new Dollar(111.22);
        currencyArray[5] = new Dollar(44.55);
        currencyArray[6] = new Dollar(77.77); 
        currencyArray[7] = new Dollar(18.36);
        currencyArray[8] = new Dollar(543.21); 
        currencyArray[9] = new Dollar(20.21);
        currencyArray[10] = new Dollar(345.67);
        currencyArray[11] = new Dollar(36.18);
        currencyArray[12] = new Dollar(48.48);
        currencyArray[13] = new Dollar(101.00);
        currencyArray[14] = new Dollar(11.00);
        currencyArray[15] = new Dollar(21.00);
        currencyArray[16] = new Dollar(51.00);
        currencyArray[17] = new Dollar(1.00);
        currencyArray[18] = new Dollar(251.00);
        currencyArray[19] = new Dollar(151.00);
       
        System.out.println("Hello! This is the start of the ADT demo done by Lucia Liu and Nithya Ramasubramonian.");
        
        System.out.println("\nSinglyLinkedList test ---------------------------------------------------------- ");
        
        // A
        SinglyLinkedList list = new SinglyLinkedList();
        
        for (int i = 6; i >= 0; i--) {
        	list.addCurrency(currencyArray[i], list.getCount());
        }
        
        // B
        System.out.println("Index of $87.43 (-1 if not found): " + list.findCurrency(new Dollar(87.43)));
        System.out.println("Index of $44.56 (-1 if not found): " + list.findCurrency(new Dollar(44.56)));

        // C
        list.removeCurrency(new Dollar(111.22));
        list.removeCurrency(2);
        
        // D
        System.out.println("List content: " + list.printList());
        
        // E
        for (int i = 8; i < 12; i++) {
        	list.addCurrency(currencyArray[i], i % 5);
        }
        
        // F
        list.removeCurrency(list.countCurrency() % 6);
        list.removeCurrency(list.countCurrency() / 7);
        
        // G
        System.out.println("List content: " + list.printList());
        
        System.out.println("\nStack test ---------------------------------------------------------- ");

        // A
        Stack stack = new Stack();
        
        for (int i = 13; i < 20; i++) {
            stack.push(currencyArray[i]);
        }
        
        // B
        System.out.println("Top of stack: " + stack.peek());

        // C
        stack.pop();
        stack.pop();
        stack.pop();
        
        // D
        System.out.println("Stack content: " + stack.printStack());

        // E
        for (int i = 0; i < 5; i++) {
            stack.push(currencyArray[i]);
        }

        // F
        stack.pop();
        stack.pop();

        // G
        System.out.println("Stack content: " + stack.printStack());
        
        System.out.println("\nQueue test ---------------------------------------------------------- ");
        Queue queue = new Queue();

        // A
        for (int i = 5; i <= 17; i += 2) {
            queue.enqueue(currencyArray[i]);
        }
        
        // B
        System.out.println("Front of the queue: " + queue.peekFront());
        System.out.println("End of the queue: " + queue.peekRear());

        // C
        Currency[] dequeuedItems = new Currency[2];
        for (int i = 0; i < 2; i++) {
            dequeuedItems[i] = queue.dequeue();
        }

        // D
        System.out.println("Queue content: " + queue.printQueue());

        // E
        for (int i = 10; i <= 15; i++) {
            queue.enqueue(currencyArray[i]);
        }

        // F
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // G
        System.out.println("Queue content: " + queue.printQueue());
    }

}
