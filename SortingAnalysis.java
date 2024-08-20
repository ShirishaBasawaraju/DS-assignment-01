

class BubbleSort {

    public long sort(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return System.currentTimeMillis() - startTime;
    }
}

class SelectionSort {

    public long sort(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return System.currentTimeMillis() - startTime;
    }
}

class InsertionSort {

    public long sort(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return System.currentTimeMillis() - startTime;
    }
}

class MergeSort {

    public long sort(int[] array) {
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1);
        return System.currentTimeMillis() - startTime;
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }
        for (i = low; i <= high; i++) {
            array[i] = temp[i - low];
        }
    }
}

class QuickSort {

    public long sort(int[] array) {
        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        return System.currentTimeMillis() - startTime;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class HeapSort {

    public long sort(int[] array) {
        long startTime = System.currentTimeMillis();
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Heap sort
        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
        return System.currentTimeMillis() - startTime;
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }
}

public class SortingAnalysis {

    public static void main(String[] args) {
        int[] sizes = {70,9,330,53,22,78,22};

        System.out.println("Array Size\tBubble Sort\tSelection Sort\tInsertion Sort\tMerge Sort\tQuick Sort\tHeap Sort (Time in ms)");
        for (int size : sizes) {
            int[] array = new int[size];
          

            // Create instances of sorting classes
            BubbleSort bs = new BubbleSort();
            SelectionSort ss = new SelectionSort();
            InsertionSort is = new InsertionSort();
            MergeSort ms = new MergeSort();
            QuickSort qs = new QuickSort();
            HeapSort hs = new HeapSort();

            // Sort arrays and measure time
            long bubbleTime = bs.sort(array.clone());
            long selectionTime =ss.sort(array.clone());
            long insertionTime = is.sort(array.clone());
            long mergeTime = ms.sort(array.clone());
            long quickTime = qs.sort(array.clone());
            long heapTime = hs.sort(array.clone());

            // Print results for the current array size
            System.out.println(size + "\t\t" + bubbleTime + "\t\t" + selectionTime + "\t\t" + insertionTime + "\t\t" + mergeTime + "\t\t" + quickTime + "\t\t" + heapTime);
        }
    }
}