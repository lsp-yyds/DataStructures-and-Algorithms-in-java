public class LinearSearch {

    private LinearSearch() {
    }

    public static <T> int search(T[] data, T target) {

        for (int i = 0; i < data.length; i++)
            // 对于类对象的判等用equals
            if (data[i].equals(target))
                return i;

        return -1;
    }

    public static void main(String[] args) {

        Student[] students = {new Student("Alice", 70), new Student("Susu", 100), new Student("Charles", 80)};
        Student susu = new Student("susu", 100);
        int res3 = LinearSearch.search(students, susu);
        System.out.println(res3);

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {

            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++)
                LinearSearch.search(data, n);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs :" + time + "s");
        }
    }
}
