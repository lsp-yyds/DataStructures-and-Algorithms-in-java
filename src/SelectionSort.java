
public class SelectionSort {
    private SelectionSort() {
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            swap(arr, i, minIndex);
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }

//      for (int e : arr)
//          System.out.print(e + " ");
//      System.out.println();

        Student[] students = {new Student("Alice", 70), new Student("Susu", 100), new Student("Charles", 80)};
        SelectionSort.sort(students);
        for (Student student : students)
            System.out.print(student + " ");
        System.out.println();
    }
}
