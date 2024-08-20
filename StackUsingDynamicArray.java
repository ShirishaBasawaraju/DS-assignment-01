class DynamicArray {

    private int[] items;
    private int count;

    public DynamicArray(int length) {
        items = new int[length];
    }

    public void push(int item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
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

    public void print() {
        for (int i = count - 1; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }
}

public class StackUsingDynamicArray {

    public static void main(String[] args) {
        DynamicArray stack = new DynamicArray(3);
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.print();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        stack.print();
    }
}
