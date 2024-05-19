package lab03;

/*
 * Name(s): Lucia Liu, Nithya Ramasubramonian
 * Due date: 5/18/24
 * Purpose: The purpose of this lab was to help us understand the application of linked data structures 
 * by implementing a link-based list and its associated ADT's (abstract data types).
 */

public class SinglyLinkedList 
{
    private int count; 
    private LinkNode start;
    private LinkNode end;
    
    public SinglyLinkedList()
    {
        count = 0;
        start = null;
        end = null;
    }
    
    /*
     * Return number of elements in the list.
     * 
     * Post: 
     * Return number of elements as an integer
     */
    public int getCount()
    {
        return count;
    }
    
    /*
     * Return the first node of the list.
     *
     * Post: 
     * Return the first node of the list if the list is not empty.
     * Return null if the list is empty.
     */
    public LinkNode getStart()
    {
        return start;
    }
    
    /*
     * Return the last node of the list.
     *
     * Post: 
     * Return the last node of the list if the list is not empty.
     * Return null if the list is empty.
     */
    public LinkNode getEnd()
    {
        return end;
    }
    
    /*
     * Add a Currency object into the list at the given index.
     * 
     * Pre:
     * curr - the reference to the Currency object. Cannot be null.
     * i    - the index at which the curr is added to the list. Cannot be negative.
     * 
     * Post:
     * An exception will be thrown if curr is null or if i negative.
     * If i is 0, the curr is added to the start of the list.
     * If i is equal to or greater than the number of elements n the list, the curr is added at the end of the list.
     */
    public void addCurrency(Currency curr, int i)
    {
    	/* 
    	Pseudocode:
    	Check if currency is null or position is negative
        Make new node with currency
        If list is empty
            start and end = new node
        Else if adding at start
            Put new node before current start
        Else if adding at end or further
            Attach new node after current end
        Else
            Insert new node at position
        Increase count by 1
    	 */
    	
    	if (curr == null) {
    		throw new IllegalArgumentException("Currency is null");
    	} else if (i < 0) {
    		throw new IllegalArgumentException("Index is negative");
    	}
    	
        LinkNode newNode = new LinkNode(curr, null);
        
        if (start == null) { // Insert as list's first node
            start = newNode;
            end = newNode;
        } else if (i+1 > count) { // Insert after list's tail node
            end.setNext(newNode);
            end = newNode; 
        } else if (i == 0) {
            newNode.setNext(start);
            start = newNode;
        } else { // Insert in middle of list
            LinkNode currNode = start;
            for (int j = 0; j < i-1; j++) {
                currNode = currNode.getNext();
            }
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
        count++;
    }
    
    /*
     * Remove the specified Currency object (with same monetary value, doesn't have to be same reference) 
     * from the list and return the Currency that was removed.
     *
     * Pre:
     * curr - the Currency object to be removed.
     * 
     * Post:
     * If the curr is found in the list, the corresponding Currency object is removed from the list and returned.
     * If the curr is not found, a null is returned.
     */
    public Currency removeCurrency(Currency curr)
    {
    	/* 
    	Pseudocode:
    	If list empty or currency is null
            Return null
        If first node has the currency
            Remove first node
        Else
            Find and remove currency in list
        Decrease count by 1 if removed
        Return currency if found, else null
    	 */
    	
    	Currency foundCurr;
    	
        if (curr == null || start == null) { // if curr or list is empty
            return null;
        } else if (start.getData().isEqual(curr)) { // if curr is at start of the list
        	foundCurr = start.getData();
            start = start.getNext();
            count--;
            if (count == 0) { // if there's only one node
                end = null;
            }
            return foundCurr;
        } else {
            LinkNode prevNode = start;
            LinkNode nextNode = prevNode.getNext();
            
            while (nextNode != null) {
            	if (nextNode.getData().isEqual(curr)) {    
            		foundCurr = nextNode.getData();
                	prevNode.setNext(nextNode.getNext());
                    count--;
                    if (nextNode == end) { // if removing last node
                        end = prevNode;
                    }
                    return foundCurr;
                } else {
                    prevNode = nextNode;
                    nextNode = prevNode.getNext();
                }
            }
            return null;
        }
    }
    
    /*
     * Remove and return the Currency object from the list at the given index 
     *
     * Pre:
     * i - the index at which the Currency object will be removed.
     * 
     * Post:
     * If i is negative or equal to or greater than the number of elements in the list, a null is returned.
     * Otherwise the Currency object at the index i is removed from the list and is returned.
     */
    public Currency removeCurrency(int i)
    {
    	/*
    	Pseudocode:
    	Check position is not negative or that list is not empty
        If removing first node
            Remove first node
        Else
            Find node at position and remove
        Adjust end if needed
        Decrease count and return removed currency
    	 */
    	
    	if (i < 0 || i >= count || start == null) { // if curr list is empty
            return null;
        } else if (i == 0) { // if removing first node
            Currency startCurr = start.getData();
            start = start.getNext();
            count--;
            if (count == 0) { // if there's only one node
                end = null;
            }
            return startCurr;
        } else { // remove from middle or end of list
            LinkNode node = start;
            
            for (int j = 0; j < i-1; j++) {
                node = node.getNext();
            }
            Currency curr = node.getNext().getData();
            node.setNext(node.getNext().getNext());
            count--;
            if (i == count) {
                end = node;
            }
            return curr;
        }
    }
    
    /*
     * Find a Currency object in the list and return its index in the list.
     * 
     * Pre:
     * curr - the Currency object to be found.
     * 
     * Post:
     * Returns -1 if the curr is not found.
     * Returns a non-negative integer indicating the index of the curr if the curr is found in the list.
     */
    public int findCurrency(Currency curr)
    {
    	/*
    	Pseudocode:
    	Start from first node
        Look for currency in list
        Return position if found, else -1
    	 */
    	
        int i = 0;
        LinkNode currNode = start;
        
        if (curr == null) {
            return -1;
        }
        
        while (currNode != null) { // reference or actual value??
            if (currNode.getData().isEqual(curr)) {
                return i;
            }
            
            currNode = currNode.getNext();
            i++;
        }
        
        return -1;
    }
    
    /*
     * Get the Currency object at the given index.
     *
     * Pre:
     * i - the index at which the Currency object will be returned.
     * 
     * Post:
     * Returns null if the index i is out of range.
     * Returns the Currency object at the index i if i is in the range.
     */
    public Currency getCurrency(int i)
    {
    	/*
    	Pseudocode:
    	Check that position is not negative or out of bounds
        Find currency at that position
        Return currency
    	 */
    	
        if (i < 0 || i >= count) {
            return null;
        }
        
        LinkNode currNode = start;

        for (int j = 0; j < i; j++) {
            currNode = currNode.getNext();
        }
        
        return currNode.getData();
    }
    
    /*
     * Print the Currency objects in the list in the order from the start to the end of the list.
     * 
     * Post:
     * Returns a string containing all the Currency objects in the list.
     */
    public String printList()
    {
        String nodeList = "";
        LinkNode currNode = start;
        
        for (int i = 0; i < count; i++) {
            nodeList += currNode.getData().toString() + "\t";
            currNode = currNode.getNext();
        }
        
        return nodeList;
    }
    
    /*
    * Check if the list is empty.
    * 
    * Post:
    * Returns true if the list is empty.
    * Returns false if the list is not empty.
    */
    public boolean isListEmpty()
    {
        return start == null;
    }
    
    /*
     * Return number of elements in the list.
     * 
     * Post: 
     * Return number of elements as an integer
     */
    public int countCurrency()
    {
        return count;
    }
}
