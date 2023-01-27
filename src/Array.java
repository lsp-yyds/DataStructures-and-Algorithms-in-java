/**
 * @className: Array
 * 动态数组
 */
public class Array<T> {

    private T[] data;
    private int size;

    // 有参构造函数
    public Array(int capacity) {
        // 强制类型转换
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造函数
    public Array() {
        this(10);
    }

    // 返回数组元素长度
    public int getSize() {
        return size;
    }

    // 返回数组长度
    public int getCapacity() {
        return data.length;
    }

    // 数组判空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在最后一个元素后添加元素
    public void addLast(T element) {
        add(size, element);
    }

    // 在第一个元素前添加元素
    public void addFirst(T element) {
        add(0, element);
    }

    // 在指定索引处添加元素
    public void add(int index, T element) {

        // 判断索引是否合法
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        // 若数组已满，则改变数组长度至2倍
        if (size == data.length)
            changeArrayLength(2 * data.length);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = element;
        size++;
    }

    // 返回指定索引处的元素值
    public T get(int index) {
        // 判断索引是否合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    // 返回最后一个元素的值
    public T getLast() {
        return get(size - 1);
    }

    // 返回第一个元素的值
    public T getFirst() {
        return get(0);
    }

    // 修改数组中指定索引处的元素值
    public void set(int index, T element) {
        data[index] = element;
    }

    // 寻找数组中是否有element元素
    public boolean contains(T element) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(element))
                return true;

        return false;
    }

    // 寻找数组中第一个element元素
    public int find(T element) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(element))
                return i;

        return -1;
    }

    // 寻找数组中所有的element元素
    //public int[] findAll(int element){}

    // 删除数组中指定索引处的元素
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        T temp = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null; // loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0)
            changeArrayLength(data.length / 2);
        return temp;
    }

    // 删除数组中第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除数组中最后一个元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 删除数组中element元素(只删除了数组中第一个element元素)
    public void removeElement(T element) {
        int index = find(element);
        if (index != -1)
            remove(index);
    }

    // TODO 删除数组中所有的element元素
    public void removeAllElement(int element) {
    }

    // 重写toString方法用于测试时输出
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();

    }

    // 改变数组长度
    private void changeArrayLength(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
