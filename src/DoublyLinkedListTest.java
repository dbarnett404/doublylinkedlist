import java.util.Scanner;

public class DoublyLinkedListTest {
    private static final int ADD_FIRST = 0;
    private static final int ADD_LAST = 1;
    private static final int ADD_AFTER = 2;
    private static final int ADD_POSITION = 3;
    private static final int REMOVE_FIRST = 4;
    private static final int REMOVE_LAST = 5;
    private static final int REMOVE_POSITION = 6;
    private static final int PRINT_BACKWARDS = 7;
    private static final int QUIT = 8;
    private static final String[] options = {"Add first", "Add last", "Add after", "Add position",
            "Remove first", "Remove last", "Print backwards", "Quit"};

    /**
     * Checks a String is a valid integer representation
     * @param intNum
     * @return
     */
    private static Integer validInt(String intNum) {
        try
        {
            return Integer.parseInt(intNum);
        }
        catch (NumberFormatException e)
        {
            System.out.println(intNum + " is not a valid integer");
            return null;
        }
    }

    /**
     * Returns a valid index for the doubly liked list
     * @param range
     * @return
     */
    private static int getIndex(int range) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        Integer num = null;
        while (!valid) {
            System.out.println("Select a valid index between 0 and " + range);
            String intNum = scanner.nextLine();
            num = validInt(intNum);
            if (num != null) {
                if (num >=0 && num <= range) {
                    valid = true;
                } else {
                    System.out.println("" + num + " must be between 0 up to " + range);
                }
            }
        }
        return num;
    }

    private static int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select from:");
        for (int i = 0; i < options.length; i++) {
            System.out.println("" + i + ": " + options[i]);
        }
        System.out.println();
        return scanner.nextInt();
    }

    private static String getItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item: ");
        return scanner.nextLine();
    }

    /**
     * Inserts an item at a specific index
     * @param doublyLinkedList
     */
    private static void addItemAtPosition(DoublyLinkedList<String> doublyLinkedList) {
        int index = getIndex(doublyLinkedList.size() - 1);
        System.out.println("Item to insert: ");
        String insertElement = getItem();
        doublyLinkedList.addItemAtPosition(insertElement, index);
    }

    private static void addItemAfterNode(DoublyLinkedList<String> doublyLinkedList) {
        System.out.println("Item to find: ");
        String findElement = getItem();
        System.out.println("Item to insert: ");
        String insertElement = getItem();
        doublyLinkedList.addAfter(findElement, insertElement);
    }

    /**
     * Removes an item at a specific index
     * @param doublyLinkedList
     */
    private static void removeItemAtPosition(DoublyLinkedList doublyLinkedList) {
        int index = getIndex(doublyLinkedList.size() - 1);
        doublyLinkedList.removeItemAtPosition(index);
    }

    /**
     * Test all methods doubly linked list methods
     */
    public static void test() {
        DoublyLinkedList<String> doublyLinkedList = ListItems.buildList();
        doublyLinkedList.printListForwards();
        System.out.println("Testing");
        for (Object object: doublyLinkedList) {
            System.out.println(object);
        }
        boolean testing = true;
        while (testing) {
            int choice = getChoice();
            switch (choice) {
                case ADD_FIRST -> doublyLinkedList.addFirst(getItem());
                case ADD_LAST -> doublyLinkedList.addLast(getItem());
                case ADD_AFTER -> addItemAfterNode(doublyLinkedList);
                case ADD_POSITION -> addItemAtPosition(doublyLinkedList);
                case REMOVE_FIRST -> doublyLinkedList.removeFirst();
                case REMOVE_LAST -> doublyLinkedList.removeLast();
                case REMOVE_POSITION -> removeItemAtPosition(doublyLinkedList);
                case PRINT_BACKWARDS -> doublyLinkedList.printListBackwards();
                case QUIT -> testing = false;
            }
            if (choice != PRINT_BACKWARDS)
                doublyLinkedList.printListForwards();
        }
    }
}
