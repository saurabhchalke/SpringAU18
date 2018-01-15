// LinkedHashMap internal implementation by Saurabh Chalke (INT164)

//This implementation is built without using a single Java collection.
//All the hash collision are hhandled using open chaining method.
//I'm using the hashCode function to get the Hash value of the key.

public class LinkedHashMapAccolite <K, V>{
	
	//Max number of unique hashes set to 100.
	private int listSize = 100;
	private LinkedHashMapNode<K, V> hashTable[] = new LinkedHashMapNode[listSize];
	private LinkedHashMapNode<K, V> head, tail;
	
	//Class to store every element of the LinkedHashMap
	class LinkedHashMapNode <K, V> {
		int key;
		V value;
		//For maintaining next node chain in case of collision.
		LinkedHashMapNode<K, V> next;	
		//For maintaining insertion order.
		LinkedHashMapNode<K, V> before, after;            
	}
	
	//Function to return the Hash value within the listSize range.
	int getKey(K key) {
		return (key.hashCode() % listSize);
	}
	
	//Method to insert a node into the LinkedHashMap.
    public void insertNode(K key, V value, LinkedHashMapNode<K,V> next) {
    	//Check if the LinkedHashMap is empty.
        if(head == null) {
        	head = tail = new LinkedHashMapNode<K, V>();
        	head.key = tail.key = (int) key;
        	head.value = tail.value = value;
        	hashTable[getKey(key)] = head;
        }
        else {
        	//Check if the element has no collisions in the hash table.
        	if(hashTable[getKey(key)] == null) {
        		LinkedHashMapNode<K, V> temp = new LinkedHashMapNode<K, V>();
        		temp.key = (int) key;
        		temp.value = value;
        		temp.before = tail;
        		tail.after = temp;
        		tail = temp;
        		hashTable[getKey(key)] = tail;
        	}
        	//Use open chaining here if a hash collision occurs
        	else {
        		LinkedHashMapNode<K, V> temp = new LinkedHashMapNode<K, V>();
        		temp.key = (int) key;
        		temp.value = value;
        		temp.before = tail;
        		tail.after = temp;
        		tail = temp;
        		LinkedHashMapNode<K, V> tempCollision = hashTable[getKey(key)];
        		while(tempCollision.next != null)
        			tempCollision = tempCollision.next;
        		tempCollision.next = temp;
        	}
        }
    }   
    
    //Method to remove remove a node from the LinkedHashMap.
    public void removeNode(K key) {
    	//Check is the key exists in the LinkedHashMap.
    	if(hashTable[getKey(key)] == null) 
    		System.out.println("Element does not exist");
    	else {
    		//Check if the key points to the head of the LinkedHashMap.
    		if(hashTable[getKey(key)] == head && hashTable[getKey(key)].key == (int) key) {
    			//Check if there is any node chained with the head.
    			if(head.next == null) {
    				head.after.before = null;
    				head = head.after;
    				hashTable[getKey(key)] = null;
    			}
    			else {
    				hashTable[getKey(key)] = head.next;
    				head.after.before = null;
    				head = head.after;
    			}
    		}
    		//Check if the key points to the tail of the LinkedHashMap without chaining.
    		else if(hashTable[getKey(key)] == tail) {
    			tail.before.after = null;
    			tail = tail.before;
    			hashTable[getKey(key)] = null;
    		}
    		//To delete any intermediate node of the LinkedHashMap.
    		else {
    			//Check if the key points to a node without collision.
    			if(hashTable[getKey(key)].next == null) {
    				hashTable[getKey(key)].before.after = hashTable[getKey(key)].after;
    				hashTable[getKey(key)].after.before = hashTable[getKey(key)].before;
    				hashTable[getKey(key)] = null;
    			}
    			//To delete a node having/within a chained collision list.
    			else {
    				LinkedHashMapNode<K, V> tempprev = null;
    				LinkedHashMapNode<K, V> tempcurr = hashTable[getKey(key)];
    				while(tempcurr != null) {
    					if(tempcurr.key == (int) key && tempcurr == tail) {
    						tail.before.after = null;
    						tail = tail.before;
    						tail.next = null;
    						return;
    					}
    					else if(tempcurr.key == (int) key && tempprev == null) {
    						hashTable[getKey(key)] = tempcurr.next;
    						tempcurr.before.after = tempcurr.after;
    						tempcurr.after.before = tempcurr.before;
    						return;
    					}
    					else if(tempcurr.key == (int) key) {
    						tempprev.next = tempcurr.next;
    						tempcurr.before.after = tempcurr.after;
    						tempcurr.after.before = tempcurr.before;
    						return;
    					}
						tempprev = tempcurr;
						tempcurr = tempcurr.next;
    				}
    			}
    		}
    	}
    }
    
    //Method to display a single node with a key input.
    void getNode(K key) {
    	if(hashTable[getKey(key)] == null)
    		System.out.println("Element does not exist");
    	else {
    		LinkedHashMapNode<K, V> temp = hashTable[getKey(key)];
    		//Check if the Node has collisions.
    		while(temp != null) {
    			if(temp.key == (int) key) {
    				System.out.println(temp.value);
    				return;
    			}
    			else
    				temp = temp.next;
    		}
    	}
    }
    
    //Print the entire LinkedHashMap in the order of insertion.
    void printList() {
    	LinkedHashMapNode<K, V> temp = head;
    	while(temp != null) {
    		if(temp.after == null) {
    			System.out.println(temp.value);
    			return;
    		}
    		System.out.print(temp.value + " -> ");
    		temp = temp.after;
    	}
    }

	public static void main(String[] args) {
		LinkedHashMapAccolite<Integer, String> linkedhashmap = new LinkedHashMapAccolite<Integer, String>();
		linkedhashmap.insertNode(101, "hello101", null);
		linkedhashmap.insertNode(201, "hello201", null);
		linkedhashmap.insertNode(120, "hello120", null);
		linkedhashmap.insertNode(134, "hello134", null);
		linkedhashmap.insertNode(159, "hel1o159", null);
		linkedhashmap.printList();
		linkedhashmap.getNode(101);
		linkedhashmap.removeNode(134);
		linkedhashmap.printList();
	}
}
