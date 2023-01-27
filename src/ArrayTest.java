public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        Array<Student> arr2 = new Array<>();
        arr2.addLast(new Student("Alice", 100));
        arr2.addLast(new Student("Bob", 66));
        arr2.addLast(new Student("Charlie", 88));
        arr2.remove(2);
        System.out.println(arr2);
    }
}
