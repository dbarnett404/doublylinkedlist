import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<Object> {
    // head is the first node
    // tail is the last node
    private Node<T> head, tail;

    //integer to store the number of items in the DoublyLinkedList
    private int size;

    //Constructor
    public DoublyLinkedList() {
        //when a new list is created, the head and tail should be null
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Returns true if the list is empty size  = 0
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    public Node<T> getHead() {
        return head;
    }
    /**
     * Return the first item in the list stored in the head node or print out a message to say "List empty"
     * and return null
     * @return
     */
    public Object getFirstItem() {
        //If the list has something in it
        if (!isEmpty()) {
            //Return what is stored in the head
            return head.getElement();
        } else {
            System.out.println("List is empty");
            return null;
        }
    }
    
    /**
     * Traverses each item in the linked list forwards
     * and prints it out as long as there are items to print
     */
    public void printListForwards() {
        // Reference to the head node to start the traversal
        Node<T> currentNode = head;
        
        // While the current node isn't empty print the item in the node
        // move on to the next node
        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            currentNode = currentNode.getNext();
        }
    }

    /**
     * Traverses each item in the linked list backwards
     * and prints it out as long as there are items to print
     */
    public void printListBackwards() {
        // Reference to the head node to start the traversal
        Node<T> currentNode = tail;

        // While the current node isn't empty print the item in the node
        // move on to the next node
        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            currentNode = currentNode.getPrevious();
        }
    }

    /**
     * Returns the number of items in the list
     * @return count
     */
    public int size() {
        return size;
    }
    
    /**
     * Add an item to the head of the linked list
     * @param element the actual item we want to add to the list
     */
    public void addFirst(T element) {
        // Allocate a new node
        Node<T> newNode = new Node<>(element);

        // if head is not set (this will be the first node)
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //have the new node point to the old head
            newNode.setNext(head);
            //The heads previous will be the new node
            head.setPrevious(newNode);
            head = newNode;
        }
        // update size
        size++;
    }

    /**
     * Add a new node at the end of the doubly linked list - make a new tail
     * @param element
     */
    public void addLast(T element) {
        // Allocate a new node and have the new node point to the old head
        // Parameters of Node are element, next and previous
        Node<T> newNode = new Node<>(element);

        // if head is not set (this will be the first node)
        //the list is empty at this point
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //have the new node previous pointer point to the tail
            newNode.setPrevious(tail);
            //the tails next pointer will be the new node
            tail.setNext(newNode);
            //The new node is now the tail
            tail = newNode;
        }
        //update size
        size++;
    }

    /**
     * Finds the node containing a specific Object element
     * @param element
     * @return the node if found or null
     */
    private Node<T> findNode(T element) {
        Node<T> currentNode = head;
        while (currentNode != null && !currentNode.getElement().equals(element)) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Method to add a node after a specified node
     * @param findElement
     * @param newElement
     */
    public void addAfter(T findElement, T newElement) {
        Node<T> previousNode = findNode(findElement);
        if (previousNode == null) {
            System.out.println(findElement + " not found!");
        } else {
            System.out.println("Inserting " + newElement + " after " + findElement);
            //Allocate a new node and have the new node point to the old head
            //element - next - previous
            Node<T> newNode = new Node<>(newElement);
            newNode.setNext(previousNode.getNext());
            newNode.setPrevious(previousNode);

            System.out.println("Head is " + head.getElement());
            previousNode.setNext(newNode);
            // If the preceding node was the tail this is the new tail
            if (tail == previousNode) {
                tail = newNode;
            }
            if (newNode.getNext() != null) {
                newNode.getNext().setPrevious(newNode);
            }
            //update count
            size++;
        }
    }

    /**
     * Removes the item at the head of the list - the first item
     * Decreases the count of the number of items in the list
     */
    public void removeFirst(){
        // update head to point to the next node in the list
        if (!isEmpty()) {
            head = head.getNext();
            //This is the last item
            if (head == null) {
                tail = null;
                System.out.println("List is now empty");
            } else
                head.setPrevious(null);
            size--;
        } else {
            System.out.println("Error - list is empty!");
        }
        // don't need to do anything else, the garbage collector will destroy the former first node
    }

    /**
     * Removes the item at the head of the list - the first item
     * Decreases the count of the number of items in the list
     */
    public void removeLast(){
        // update head to point to the next node in the list
        if (!isEmpty()) {
            tail = tail.getPrevious();
            if (tail == null) {
                head = null;
                System.out.println("List is now empty");
            } else
                tail.setNext(null);
            size--;
        } else {
            System.out.println("Error - list is empty!");
        }
        // don't need to do anything else, the garbage collector will destroy the former last node
    }

    /**
     * Method to check if a position index is a valid number
     * Prints out an error if it's not a valid position within the range of items
     */
    private boolean checkPosition(int position) {
        return (position >= 0 && position < this.size());
    }

    /**
     * Returns the node at a specific index or null if not found
     * @param position
     * @return
     */
    public Node<T> getNodeAt(int position) {
        if (checkPosition(position)) {
            //set up a traversal up to the correct position
            int currentPos = 0;
            Node<T> currentNode = head;

            while (currentPos < position && currentNode != null) {
                currentPos++;
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }
        System.out.println("Error - invalid position supplied!");
        return null;
    }

    /**
     * Find the item at a specific index
     * @param position the index of the item
     * @return the item or null
     */
    public Object getItemAt(int position){
        Node<T> currentNode = getNodeAt(position);
        if (currentNode != null) {
            return currentNode.getElement();
        } else {
            return null;
        }
    }

    /**
     * Insert an object at a specific position in the list
     * @param element
     * @param position
     */
    public void addItemAtPosition(T element, int position) {
        //We are adding at the tail
        if (position == size) {
            addLast(element);
        } else {
            Node<T> currentNode = getNodeAt(position);
            if (currentNode != null) {
                System.out.println("Current node is " + currentNode.getElement() + " Position is " + position);
                //Allocate a new node and have the new node point to the old head element - next - previous
                Node<T> newNode = new Node<>(element);
                newNode.setNext(currentNode);
                newNode.setPrevious(currentNode.getPrevious());
                currentNode.getPrevious().setNext(newNode);
                currentNode.setPrevious(newNode);
                //now increment size
                size++;
            }
        }
    }

    /**
     * Returns the index of an item
     * @param element
     * @return the position of the item in the list -1 if not found
     */
    public int getItemPosition(T element) {
        int currentPos = 0;
        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getElement().equals(element)) {
                return currentPos;
            }
            currentNode = currentNode.getNext();
            currentPos++;
        }
        return -1;
    }


    /**
     * Remove the item at a given position in the list
     * @param position the index of the item to be removed (starting from 0)
     */
    public void removeItemAtPosition(int position) {
        // First check that it is a valid position and return null if not.
        if (checkPosition(position)) {
            if (position == 0) {
                removeFirst();
            } else if (position == size -1) {
                removeLast();
            } else {
                Node<T> currentNode = getNodeAt(position);
                if (currentNode != null) {
                    System.out.println("Removing " + currentNode.getElement() + " at position " + position);
                    if (currentNode.getPrevious() != null)
                        currentNode.getPrevious().setNext(currentNode.getNext());
                    if (currentNode.getNext() != null) {
                        currentNode.getNext().setPrevious(currentNode.getPrevious());
                    }
                }
                //now decrement count
                size--;
            }
        } else {
            System.out.println("Error - invalid position supplied!");
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new DoublyLinkedListIterator<>(this);
    }

}