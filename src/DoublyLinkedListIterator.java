import java.util.Iterator;

public class DoublyLinkedListIterator<T> implements Iterator<Object> {
    Node<T> current;
    // initialize pointer to head of the list for iteration
    public DoublyLinkedListIterator(DoublyLinkedList<T> doublyLinkedList) {
        current = doublyLinkedList.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext() {
        return current != null;
    }

    // return current data and update pointer
    public T next()  {
        T element = current.getElement();
        current = current.getNext();
        return element;
    }

    // implement if needed
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
