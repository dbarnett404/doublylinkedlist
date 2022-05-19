public class Node<T>	{
    //The object we are storing
    private final T element;
    //References to the previous and next nodes
    //i.e. the node it came from and the node it is going to!
    private  Node<T> previous, next;

    // Creates a node with just the element initialised
    public  Node(T element)	{
        this.next  =  null;
        this.previous  =  null;
        this.element = element;
    }

    // Accessor methods:
    public  T getElement()  {
       return  element;
   }

    public  Node<T> getNext()  {
       return  next;
   }

    public void  setNext(Node<T> newNext)  {
         next  =  newNext;
   }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }
}

