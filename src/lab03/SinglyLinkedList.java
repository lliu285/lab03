package lab03;

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
     * 
     */
    public int getCount()
    {
        return count;
    }
    
    /*
     * 
     */
    public LinkNode getStart()
    {
        return start;
    }
    
    /*
     * 
     */
    public LinkNode getEnd()
    {
        return end;
    }
    
    /*
     * Add currency at the index specified.
     * For example:
     * 
     * 2.40  5.43  2.33
     * 
     * addCurrency(3.88, 1) results in:
     * 2.40  3.88  5.43  2.33
     * 
     * 
     * addCurrency method which takes a Currency object 
     * and a node index value as parameters to add the Currency to the list at that index.
     */
    public void addCurrency(Currency curr, int i)
    {
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
            
            newNode.setNext(currNode.getNext()); // have to fix this
            currNode.setNext(newNode);
        }
        count++;
    }
    
    /*
     * note: removing Currency with the same data, not the same reference (clarified w/ prof)
     * In the list: 2.40  5.43  2.33
     * you can remove 5.43 by calling removeCurrency(new Dollar(5.43)
     * 
     * 
     * removeCurrency method which takes a Currency object as parameter 
     * and removes that Currency object from the list and may return a copy of the Currency.
     */
    public Currency removeCurrency(Currency curr)
    {
        if (curr == null || start == null) { // if curr or list is empty
            return null;
        } else if (start.getData().isEqual(curr)) { // if curr is at start of the list
            start = start.getNext();
            count--;
            if (count == 0) { // if there's only one node
                end = null;
            }
            return curr;
        } else {
            LinkNode prevNode = start;
            LinkNode nextNode = prevNode.getNext();
            
            while (nextNode != null) {
            	if (nextNode.getData().isEqual(curr)) {     
                	prevNode.setNext(nextNode.getNext());
                    count--;
                    if (nextNode == end) { // if removing last node
                        end = prevNode;
                    }

                    return curr;
                } else {
                    prevNode = nextNode;
                    nextNode = prevNode.getNext();
                }
            }
            return null;
        }
    }
    
    /*
     * removeCurrency overload method which takes a node index as parameter 
     * and removes the Currency object at that index and may return a copy of the Currency
     */
    public Currency removeCurrency(int i)
    {
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
     * note: finds the currency object with the same monetary value, not the same reference
     * 
     * findCurrency method which takes a Currency object as parameter 
     * and returns the node index at which the Currency is found in the
     * list and returns -1 if not found.
     * 
     */
    public int findCurrency(Currency curr)
    {
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
    
    public Currency getCurrency(int i)
    {
        if (i < 0 || i >= count) {
            return null;
        }
        
        LinkNode currNode = start;

        for (int j = 0; j < i; j++) {
            currNode = currNode.getNext();
        }
        
        return currNode.getData();
    }
    
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
    
    public boolean isListEmpty()
    {
        return start == null;
    }
    
    public int countCurrency()
    {
        return count;
    }
}
