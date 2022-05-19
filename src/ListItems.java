public class ListItems {
    //public static final String[] items = {"ant", "bee", "cat", "dog", "eel", "fly", "goat", "hen", "ibex"};


    public static DoublyLinkedList<String> buildList() {
        final String[] items = {"ant", "bee"};
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        for (String item: items) {
            //Add each item in the Array to the tail of the linked list
            doublyLinkedList.addLast(item);
        }
        return doublyLinkedList;
    }
}
