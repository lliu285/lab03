package lab03;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose:
 */

public class LinkNode 
{
	private Currency data; // pointer/reference??
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
	 * Return the Currency data of the node.
	 */
	public Currency getData()
	{
		return data;
	}
	
	
	/*
	 * Pre:
	 * data - Currency of new data
	 * can it be null??
	 * 
	 * Post:
	 * 
	 */
	public void setData(Currency data)
	{
		this.data = data;
	}
	
	/*
	 * 
	 */
	public LinkNode getNext()
	{
		return next;
	}
	
	/*
	 * 
	 */
	public void setNext(LinkNode next)
	{
		this.next = next;
	}
}
