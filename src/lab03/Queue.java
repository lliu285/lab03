package lab03;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 */

public class Queue 
{
    private SinglyLinkedList list;
    
    public Queue()
    {
        list = new SinglyLinkedList();
    }
    
    /*
     * list's head node = queue's front
     * list's tail node = queue's end
     * 
     * takes a Currency object as parameter and adds it to the end of the queue
     */
    public void enqueue(Currency curr)
    {
        list.addCurrency(curr, list.getCount());
    }
    
    public Currency dequeue()
    {
        return list.removeCurrency(0);
    }
    
    public Currency peekFront()
    {
        return list.getCurrency(0);
    }
    
    public Currency peekRear()
    {
        return list.getCurrency(list.getCount() - 1);
    }
    
    public String printQueue()
    {
        return list.printList();
    }
    
}
