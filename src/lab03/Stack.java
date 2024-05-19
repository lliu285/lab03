package lab03;

public class Stack
{
    private SinglyLinkedList list;
    
    public Stack()
    {
        list = new SinglyLinkedList();
    }
    
    /*
     * Add a Currency object at the top of the stack.
     * 
     * Pre:
     * curr - the reference to the Currency object. Cannot be null.
     * 
     * Post:
     * An exception will be thrown if curr is null or if i negative.
     * If i is 0, the curr is added to the start of the list.
     * If i is equal to or greater than the number of elements n the list, the curr is added at the end of the list.
     */
    public void push(Currency curr)
    {
        list.addCurrency(curr, 0);
    }
    
    public Currency pop()
    {
        return list.removeCurrency(0);
    }
    
    public Currency peek()
    {
        return list.getCurrency(0);
    }
    
    public String printStack()
    {
        return list.printList();
    }
}
