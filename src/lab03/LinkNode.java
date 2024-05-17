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
	
	public Currency getData()
	{
		return data;
	}
	
	public void setData(Currency data)
	{
		this.data = data;
	}
	
	public LinkNode getNext()
	{
		return next;
	}
	
	public void setNext(LinkNode next)
	{
		this.next = next;
	}
}
