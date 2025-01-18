import java.util.Arrays;

public class MinHeap {
    private int capacity;
    private int size;
    private int[] items;

    public MinHeap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity];
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParent(int index) {
        return items[getParentIndex(index)];
    }

    public int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public int getRightChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size++] = item;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[index] < getParent(index)){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)){
            int smallestChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index))
                smallestChildIndex = getRightChildIndex(index);
            if(items[index] < items[smallestChildIndex])
                break;
            else swap(index, smallestChildIndex);

            index = smallestChildIndex;

        }
    }
}
