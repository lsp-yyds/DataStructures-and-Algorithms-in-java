import java.util.Random;

/**
 * @className: ArrayGenerator
 * 实现功能如下：
 * 1.生成从0到n-1指定长度为n的顺序数组
 * 2.生成长度为n的随机数数组
 * 3.
 */
public class ArrayGenerator {
    private ArrayGenerator() {
    }

    // 生成从0到n-1指定长度为n的顺序数组
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    // 生成长度为n的随机数数组
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(bound);
        return arr;
    }
}
