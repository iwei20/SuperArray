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

    public void add(String element) {
        if(size >= data.length) resize();
        data[size] = element;
        ++size;
    }

    public String get(int index) {
        return data[index];
    }

    public String set(int index, String element) {
        String temp = data[index];
        data[index] = element;
        return temp;
    }

    private void resize() {
        String[] temp = new String[data.length + 10];
        for(int i = 0; i < data.length; ++i) {
            temp[i] = data[i];
        }
        data = temp;
    }
}