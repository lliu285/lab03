package lab03;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 */

public class LinkNode 
{
    private Currency data;
    private LinkNode next;
    
    public LinkNode()
    {
         data = null;
         next = null;
    }
    
    public LinkNode(Currency data, LinkNode next)
    {
         this.data = data;
         this.next = next;
    }
    
    /*
     * Post:
     * Return the data attribute of the node.
     */
    public Currency getData()
    {
        return data;
    }
    
    
    /*
     * Pre:
     * data - the Currency value of data attribute to set.
     * 
     * Post:
     * The data attribute has been set.
     */
    public void setData(Currency data)
    {
        this.data = data;
    }
    
    /*
     * Post:
     * Returns the next LinkNode attribute.
     */
    public LinkNode getNext()
    {
        return next;
    }
    
    /*
     * Pre:
     * next - the LinkNode value of next attribute to be set.
     * 
     * Post:
     * The next LinkNode attribute has been set.
     */
    public void setNext(LinkNode next)
    {
        this.next = next;
    }
}
