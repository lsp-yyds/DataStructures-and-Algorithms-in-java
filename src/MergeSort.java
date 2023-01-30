import java.util.Arrays;

public class MergeSort<T> {

    private MergeSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int left, int right) {
        if (left >= right)
            return;

        int middle = left + (right - left) / 2;
        sort(arr, left, middle);
        sort(arr, middle + 1, right);
        if (arr[middle].compareTo(arr[middle + 1]) > 0)
            merge(arr, left, middle, right);
    }

    // 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {

        T[] temp = Arrays.copyOfRange(arr, left, right + 1);

        int startOfFirst = left, startOfSecond = middle + 1;

        for (int position = left; position <= right; position++) {
            if (startOfFirst > middle) {
                arr[position] = temp[startOfSecond - left];
                startOfSecond++;
            } else if (startOfSecond > right) {
                arr[position] = temp[startOfFirst - left];
                startOfFirst++;
            } else if (temp[startOfFirst - left].compareTo(temp[startOfSecond - left]) <= 0) {
                arr[position] = temp[startOfFirst - left];
                startOfFirst++;
            } else {
                arr[position] = temp[startOfSecond - left];
                startOfSecond++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        // Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        // SortingHelper.sortTest("SelectionSort", arr);
        // SortingHelper.sortTest("InsertionSort", arr2);
        SortingHelper.sortTest("MergeSort", arr3);
    }
}
