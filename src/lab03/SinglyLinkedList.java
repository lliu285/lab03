package lab03;

public class SinglyLinkedList 
{
	private int count;
	private LinkNode start;
	private LinkNode end;
	
	public SinglyLinkedList()
	{
		count = 0;
		start = new LinkNode();
		end = new LinkNode();
	}
	
	public int getCount()
	{
		return count;
	}
	
	public LinkNode getStart()
	{
		return start;
	}
	
	public LinkNode getEnd()
	{
		return end;
	}
	
	public int createList() // change return type later
	{
		return 0; 
	}
	
	public void destroyList() // change return type later
	{
		
	}
	
	public void addCurrency(Currency curr, int i)
	{
		
	}
	
	public Currency removeCurrency(int i)
	{
		Currency curr = new Dollar();
		return curr;
	}
	
	public int findCurrency(Currency curr)
	{
		return 0;
	}
	
	public Currency getCurrency(int i)
	{
		Currency curr = new Dollar();
		return curr;
	}
	
	public String printList()
	{
		return "";
	}
	
	public boolean isListEmpty()
	{
		return false;
	}
	
	public int countCurrency()
	{
		return 0;
	}
}
