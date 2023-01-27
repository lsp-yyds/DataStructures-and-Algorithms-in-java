import java.util.Arrays;

public class MergeSort<T> {

    private MergeSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {

    }

    private static <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
        T[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }
}
