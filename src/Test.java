public class Test {

    public static int sum(int[] arr) {
        return sum(arr, arr.length - 1);
    }

    private static int sum(int[] arr, int n) {
        if (n >= 0)
            return arr[n] + sum(arr, n - 1);
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
