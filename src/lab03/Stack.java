package lab03;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 */

public class Stack
{
    private SinglyLinkedList list;
    
    public Stack()
    {
        list = new SinglyLinkedList();
    }
    
    /*
     * Add a Currency object at the top of the stack.
     * Top of the stack is represented as the first node in the list.
     * 
     * Pre:
     * curr - the reference to the Currency object. Cannot be null.
     * 
     * Post:
     * An exception will be thrown if curr is null or if i negative.
     */
    public void push(Currency curr)
    {
        list.addCurrency(curr, 0);
    }
    
    /*
     * Post:
     * Return and remove the Currency object from the top of the stack. Returns null if the stack is empty.
     * Top of the stack is represented as the first node in the list.
     */
    public Currency pop()
    {
        return list.removeCurrency(0);
    }
    
    /*
     * Post:
     * Return the Currency object at the top of the stack.
     */
    public Currency peek()
    {
        return list.getCurrency(0);
    }
    
    /*
     * Print the Currency objects in the stack in the order from the top of the stack to the end of the stack.
     * 
     * Post:
     * Returns a string containing all the Currency objects in the stack.
     */
    public String printStack()
    {
        return list.printList();
    }
}
