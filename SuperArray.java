public class SuperArray {
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
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

    public String get(int index) {
        return data[index];
    }

    public String set(int index, String element) {
        String temp = data[index];
        data[index] = element;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String result = "[";
        for(int i = 0; i < size - 1; ++i) {
            result += data[i];
        }
        result += data[size - 1] + "]";
        return result;
    }

    private void resize() {
        String[] temp = new String[data.length + 10];
        for(int i = 0; i < data.length; ++i) {
            temp[i] = data[i];
        }
        data = temp;
    }
}