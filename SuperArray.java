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
        for(int i = size - 1; i >= index; --i) {
            data[i + 1] = data[i];
        }
        ++size;
        data[index] = element;
    }

    public String remove(int index) {
        String temp = data[index];
        for(int i = index; i < size - 1; ++i) {
            data[i] = data[i + 1];
        }
        --size;
        return temp;
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

    public int indexOf(String s) {
        for(int i = 0; i < size; ++i) {
            if(data[i].equals(s)) return i;
        }
        return -1;
    }

    private void resize() {
        String[] temp = new String[data.length * 2]; // Factor in copy speed and benefit from max size
        for(int i = 0; i < data.length; ++i) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public static void removeDuplicates(SuperArray s) {
        for(int i = s.size() - 1; i >= 0; --i) {
            if(i != s.indexOf(s.get(i))) s.remove(i);
        }
    }

    public static SuperArray findOverlap(SuperArray a, SuperArray b) {
        SuperArray result = new SuperArray();
        for(int i = 0; i < a.size(); ++i) {
            if(b.contains(a.get(i))) result.add(a.get(i));
        }
        removeDuplicates(result);
        return result;
    }
}