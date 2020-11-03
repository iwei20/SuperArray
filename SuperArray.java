public class SuperArray {
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    public SuperArray(int initialCapacity) {
        data = new String[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(String element) {
        if(size >= data.length) resize();
        data[size] = element;
        ++size;
        return true;
    }

    public void add(int index, String element) {
        if(size >= data.length) resize();
        for(int i = size - 1; i >= index; ++i) {
            data[i + 1] = data[i];
        }
        data[index] = element;
    }

    public String get(int index) {
        return data[index];
    }

    public String set(int index, String element) {
        String temp = data[index];
        data[index] = element;
        return temp;
    }

    public void clear() {
        data = new String[size];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String result = "[";
        for(int i = 0; i < size - 1; ++i) {
            result += data[i] + ", ";
        }
        result += data[size - 1] + "]";
        return result;
    }

    public boolean contains(String s) {
        for(int i = 0; i < size; ++i) {
            // For ease of programming, for now our list strictly doesn't care about null
            // Remember that equals fails on null
            if(data[i].equals(s)) return true;
        }
        return false;
    }

    private void resize() {
        String[] temp = new String[data.length * 2]; // Factor in copy speed and benefit from max size
        for(int i = 0; i < data.length; ++i) {
            temp[i] = data[i];
        }
        data = temp;
    }
}