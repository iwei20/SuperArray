public class SuperArray {
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    public SuperArray(int initialCapacity) {
        if(initialCapacity < 0) throw new IllegalArgumentException("Negative initial capacity " + initialCapacity);
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
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        if(size >= data.length) resize();
        for(int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
        }
        ++size;
        data[index] = element;
    }

    public String remove(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        String temp = data[index];
        for(int i = index; i < size - 1; ++i) {
            data[i] = data[i + 1];
        }
        --size;
        return temp;
    }

    public String get(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        return data[index];
    }

    public String set(int index, String element) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
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

    public String[] toArray() {
        String[] result = new String[size];
        for(int i = 0; i < size; ++i) {
            result[i] = data[i];
        }
        return result;
    }

    public String toString() {
        if(size == 0) return "[]";
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

    public boolean equals(SuperArray other) {
        if(size != other.size()) return false;
        for(int i = 0; i < size; ++i) {
            if(data[i] != other.get(i)) return false; 
        }
        return true;
    }

    public int indexOf(String s) {
        for(int i = 0; i < size; ++i) {
            if(data[i].equals(s)) return i;
        }
        return -1;
    }

    public int lastIndexOf(String value) {
        for(int i = size - 1; i >= 0; --i) {
            if(data[i].equals(value)) return i;
        }
        return -1;
    }

    private void resize() {
        String[] temp = new String[data.length * 2 + 1]; // Factor in copy speed and benefit from max size
        for(int i = 0; i < data.length; ++i) {
            temp[i] = data[i];
        }
        data = temp;
    }

}