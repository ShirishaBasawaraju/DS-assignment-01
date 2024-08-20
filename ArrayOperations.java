public class ArrayOperations {
    private int[] items;
    private int count;

    public ArrayOperations(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Invalid index");
        }
        resizeIfRequired();
        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        count++;
    }

    public void remove() {
        if (count == 0) {
            throw new IllegalStateException("Array is empty");
        }
        count--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Invalid index");
        }
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public void print(String operationName) {
        System.out.print(operationName + ": ");
        if (count == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    public static void main(String[] args) {
        ArrayOperations array = new ArrayOperations(3);

        // Insert elements
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.print("Insert 10, 20, 30");

        // Insert at specific index
        array.insertAt(15, 1);
        array.print("Insert 15 at index 1");

        // Remove last element
        array.remove();
        array.print("Remove last element");

        // Remove at specific index
        array.removeAt(1);
        array.print("Remove element at index 1");

        // Exception handling
        try {
            array.insertAt(25, 10); // Invalid index
        } catch (IllegalArgumentException ex) {
            System.out.println("Insert 25 at index 10: " + ex.getMessage());
        }

        try {
            array.removeAt(5); // Invalid index
        } catch (IllegalArgumentException ex) {
            System.out.println("Remove element at index 5: " + ex.getMessage());
        }

        try {
            array.remove(); // Removing from an empty array
            array.remove();
            array.remove();
            array.remove();
        } catch (IllegalStateException ex) {
            System.out.println("Remove element from empty array: " + ex.getMessage());
        }
    }
}
